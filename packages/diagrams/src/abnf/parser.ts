import { Token } from './token.js';
import { TokenKind } from './token-kind.js';
import { TokenStream, SyntaxException } from './token-stream.js';
import { AstNode } from './ast-node.js';

/**
 * Clean implementation of ABNF parser based on the C# architecture
 * This parser operates on tokens produced by the Scanner and builds an AST following the ABNF grammar.
 * Key principle: ABNF rules can span multiple lines, so we must distinguish between:
 * - Rule boundaries: lines starting with rulename =
 * - Continuation lines: all other lines that are part of the current rule
 */
export class Parser {
  private readonly tokens: TokenStream;
  private readonly fileName?: string;

  constructor(tokens: Token[], fileName?: string) {
    this.tokens = new TokenStream(tokens);
    this.fileName = fileName;
  }

  private match(kind: TokenKind): boolean {
    return this.tokens.match(kind);
  }

  private expect(kind: TokenKind): Token {
    return this.tokens.expect(kind, this.fileName);
  }

  /**
   * Skips whitespace and comments but NOT CRLF (which is significant for rule boundaries)
   */
  private skipTrivia(): void {
    this.tokens.skipTrivia();
  }

  /**
   * Parses: rulelist = 1*( rule / (*c-wsp c-nl) )
   * In our token implementation: sequence of rules separated by CRLF, with optional comments/whitespace
   */
  parseRuleList(): AstNode.RuleList {
    const rules: AstNode.Rule[] = [];

    // Skip any initial trivia
    while (this.match(TokenKind.Whitespace) || this.match(TokenKind.Comment) || this.match(TokenKind.CRLF)) {
      this.tokens.moveNext();
    }

    while (!this.match(TokenKind.EndOfInput)) {
      if (this.tokens.isAtRuleStart()) {
        rules.push(this.parseRule());
      } else {
        // Skip trivia between rules
        if (this.match(TokenKind.Whitespace) || this.match(TokenKind.Comment) || this.match(TokenKind.CRLF)) {
          this.tokens.moveNext();
        } else {
          const current = this.tokens.current;
          throw new SyntaxException(
            `Expected rule name but found ${current.kind}`,
            this.fileName,
            current.line,
            current.column
          );
        }
      }
    }

    return AstNode.RuleList(rules);
  }

  /**
   * Parses: rule = rulename defined-as elements c-nl
   * In our token implementation: RuleName Equal Expression (potentially spanning multiple lines)
   * Rules can span multiple lines - only a new rulename = starts a new rule
   */
  private parseRule(): AstNode.Rule {
    const name = this.expect(TokenKind.RuleName).value;
    this.skipTrivia();
    this.expect(TokenKind.Equal);
    this.skipTrivia();

    const expr = this.parseAlternation();

    // Rule ends when we hit a rule boundary (CRLF followed by new rule or end of input)
    this.skipTrivia(); // Allow trailing whitespace/comments
    this.tokens.skipContinuationLines(); // Skip CRLF that are part of this rule

    if (this.match(TokenKind.CRLF) && this.tokens.isAtRuleBoundary()) {
      this.tokens.moveNext();
    } else if (!this.match(TokenKind.EndOfInput)) {
      const current = this.tokens.current;
      throw new SyntaxException('Expected end of rule (CRLF)', this.fileName, current.line, current.column);
    }

    return AstNode.Rule(name, expr);
  }

  /**
   * Parses: alternation = concatenation *("/" concatenation)
   * Can now span multiple lines - only rule boundaries (new rulename =) stop alternation
   */
  private parseAlternation(): AstNode.Expression {
    const options: AstNode.Expression[] = [this.parseConcatenation()];

    while (true) {
      this.skipTrivia();
      this.tokens.skipContinuationLines(); // Allow alternation to continue across lines

      // Stop at rule boundary or end of input
      if (this.tokens.isAtRuleBoundary() || this.match(TokenKind.EndOfInput)) {
        break;
      }

      if (this.match(TokenKind.Slash)) {
        this.tokens.moveNext();
        this.skipTrivia();
        this.tokens.skipContinuationLines(); // Allow continuation after slash
        options.push(this.parseConcatenation());
      } else {
        break;
      }
    }

    return options.length === 1 ? options[0] : AstNode.Alternation(options);
  }

  /**
   * Parses: concatenation = repetition *(1*c-wsp repetition)
   * Can now span multiple lines - only rule boundaries stop concatenation
   */
  private parseConcatenation(): AstNode.Expression {
    const elements: AstNode.Expression[] = [this.parseRepetition()];

    while (true) {
      this.skipTrivia();
      this.tokens.skipContinuationLines(); // Allow concatenation to continue across lines

      // Stop at rule boundary or end of input
      if (this.tokens.isAtRuleBoundary() || this.match(TokenKind.EndOfInput)) {
        break;
      }

      // Check if next token can start an element
      if (this.isElementStart()) {
        elements.push(this.parseRepetition());
      } else {
        break;
      }
    }

    return elements.length === 1 ? elements[0] : AstNode.Concatenation(elements);
  }

  /**
   * Parses: repetition = [repeat] element
   */
  private parseRepetition(): AstNode.Expression {
    let min: number | undefined;
    let max: number | undefined;

    if (this.match(TokenKind.Repeat)) {
      const repeatToken = this.expect(TokenKind.Repeat).value;
      
      if (repeatToken === '*') {
        // Handle standalone * as 0* (zero or more)
        min = 0;
        max = undefined; // unlimited
      } else {
        // Handle other repetition patterns like 1*2, 1*, *2
        const parts = repeatToken.split('*');
        min = parts[0] === '' ? undefined : parseInt(parts[0], 10);
        max = parts.length > 1 && parts[1] !== '' ? parseInt(parts[1], 10) : undefined;
      }
    }

    const element = this.parseElement();

    if (min !== undefined || max !== undefined) {
      return AstNode.Repetition(min, max, element);
    } else {
      return element;
    }
  }

  /**
   * Parses: element = rulename / group / option / char-val / num-val / prose-val
   */
  private parseElement(): AstNode.Expression {
    if (this.match(TokenKind.RuleName)) {
      const name = this.expect(TokenKind.RuleName).value;
      return AstNode.RuleRef(name);
    }

    if (this.match(TokenKind.OpenParen)) {
      return this.parseGroup();
    }

    if (this.match(TokenKind.OpenBracket)) {
      return this.parseOption();
    }

    if (this.match(TokenKind.CharVal)) {
      const value = this.expect(TokenKind.CharVal).value;
      return AstNode.Literal(value, false); // case-insensitive
    }

    if (this.match(TokenKind.CaseSensitiveCharVal)) {
      const value = this.expect(TokenKind.CaseSensitiveCharVal).value;
      return AstNode.Literal(value, true); // case-sensitive
    }

    if (this.match(TokenKind.CaseInsensitiveStringVal)) {
      const value = this.expect(TokenKind.CaseInsensitiveStringVal).value;
      return AstNode.Literal(value, false); // RFC 7405: %i"..." case-insensitive
    }

    if (this.match(TokenKind.CaseSensitiveStringVal)) {
      const value = this.expect(TokenKind.CaseSensitiveStringVal).value;
      return AstNode.Literal(value, true); // RFC 7405: %s"..." case-sensitive
    }

    if (this.match(TokenKind.NumVal)) {
      const value = this.expect(TokenKind.NumVal).value;
      return AstNode.NumberVal(value);
    }

    if (this.match(TokenKind.ValueRange)) {
      const value = this.expect(TokenKind.ValueRange).value;
      return AstNode.NumberVal(value);
    }

    if (this.match(TokenKind.ProseVal)) {
      const value = this.expect(TokenKind.ProseVal).value;
      return AstNode.ProseVal(value);
    }

    if (this.match(TokenKind.Integer)) {
      const value = this.expect(TokenKind.Integer).value;
      return AstNode.NumberVal(value);
    }

    throw new SyntaxException(
      `Expected element but found ${this.tokens.current.kind}`,
      this.fileName,
      this.tokens.current.line,
      this.tokens.current.column
    );
  }

  /**
   * Parses: group = "(" *c-wsp alternation *c-wsp ")"
   */
  private parseGroup(): AstNode.Expression {
    this.expect(TokenKind.OpenParen);
    this.skipTrivia();
    const inner = this.parseAlternation();
    this.skipTrivia();
    this.expect(TokenKind.CloseParen);
    return AstNode.Group(inner);
  }

  /**
   * Parses: option = "[" *c-wsp alternation *c-wsp "]"
   */
  private parseOption(): AstNode.Expression {
    this.expect(TokenKind.OpenBracket);
    this.skipTrivia();
    const inner = this.parseAlternation();
    this.skipTrivia();
    this.expect(TokenKind.CloseBracket);
    return AstNode.Option(inner);
  }

  /**
   * Checks if the current token can start an element
   */
  private isElementStart(): boolean {
    return this.match(TokenKind.RuleName) ||
           this.match(TokenKind.OpenParen) ||
           this.match(TokenKind.OpenBracket) ||
           this.match(TokenKind.CharVal) ||
           this.match(TokenKind.CaseSensitiveCharVal) ||
           this.match(TokenKind.CaseInsensitiveStringVal) ||
           this.match(TokenKind.CaseSensitiveStringVal) ||
           this.match(TokenKind.NumVal) ||
           this.match(TokenKind.ValueRange) ||
           this.match(TokenKind.ProseVal) ||
           this.match(TokenKind.Integer) ||
           this.match(TokenKind.Repeat);
  }
}
