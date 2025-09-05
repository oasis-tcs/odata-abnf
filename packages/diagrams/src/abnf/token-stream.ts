import { Token } from './token.js';
import { TokenKind } from './token-kind.js';

export class SyntaxException extends Error {
  constructor(message: string, public readonly file?: string, public readonly line?: number, public readonly column?: number) {
    const filePart = file || '<input>';
    const location = line !== undefined && column !== undefined ? ` at ${line}:${column}` : '';
    super(`${filePart}${location}: ${message}`);
    this.name = 'SyntaxException';
  }
}

/**
 * Encapsulates a token array with current position state and provides safe access methods.
 * This simplifies parsing by bundling position tracking with bounds-safe token access
 * and adds semantic methods for ABNF-specific parsing needs like:
 * - Distinguishing between new rule definitions (lines starting with rulename =)
 * - Detecting continuation lines (part of the current rule's definition)
 */
export class TokenStream {
  private readonly tokens: Token[];
  private position = 0;

  constructor(tokens: Token[]) {
    this.tokens = [...tokens];
  }

  /**
   * Gets the current token without consuming it
   */
  get current(): Token {
    return this.position < this.tokens.length ? this.tokens[this.position] : this.createEndOfInputToken();
  }

  /**
   * Checks if we're at the end of the token stream
   */
  get isAtEnd(): boolean {
    return this.position >= this.tokens.length;
  }

  /**
   * Gets the current position in the token stream
   */
  get positionIndex(): number {
    return this.position;
  }

  /**
   * Advances to the next token
   */
  moveNext(): void {
    if (this.position < this.tokens.length) {
      this.position++;
    }
  }

  /**
   * Looks ahead at the token at the specified offset from current position
   * @param offset Offset from current position (0 = current, 1 = next, etc.)
   * @returns The token at the specified offset, or EndOfInput if beyond the end
   */
  peek(offset = 0): Token {
    const targetPos = this.position + offset;
    return targetPos < this.tokens.length ? this.tokens[targetPos] : this.createEndOfInputToken();
  }

  /**
   * Checks if the current token matches the specified kind
   */
  match(kind: TokenKind): boolean {
    return this.current.kind === kind;
  }

  /**
   * Expects the current token to be of the specified kind, consuming it if it matches
   * @param kind The expected token kind
   * @param fileName Optional filename for error reporting
   * @returns The consumed token
   * @throws SyntaxException if the current token doesn't match
   */
  expect(kind: TokenKind, fileName?: string): Token {
    if (this.current.kind !== kind) {
      throw new SyntaxException(
        `Expected ${kind} but found ${this.current.kind}`,
        fileName,
        this.current.line,
        this.current.column
      );
    }

    const token = this.current;
    this.moveNext();
    return token;
  }

  /**
   * Skips whitespace and comments but NOT CRLF (which is significant for rule boundaries)
   */
  skipTrivia(): void {
    while (this.match(TokenKind.Whitespace) || this.match(TokenKind.Comment)) {
      this.moveNext();
    }
  }

  /**
   * Checks if the current position represents the start of a new rule definition.
   * A new rule starts with: [whitespace] rulename [whitespace] =
   */
  isAtRuleStart(): boolean {
    let pos = this.position;

    // Skip any leading whitespace/comments (but not CRLF)
    while (pos < this.tokens.length &&
           (this.tokens[pos].kind === TokenKind.Whitespace || this.tokens[pos].kind === TokenKind.Comment)) {
      pos++;
    }

    // Must have a rule name
    if (pos >= this.tokens.length || this.tokens[pos].kind !== TokenKind.RuleName) {
      return false;
    }

    pos++; // Skip the rule name

    // Skip whitespace after rule name
    while (pos < this.tokens.length && this.tokens[pos].kind === TokenKind.Whitespace) {
      pos++;
    }

    // Must be followed by =
    return pos < this.tokens.length && this.tokens[pos].kind === TokenKind.Equal;
  }

  /**
   * Checks if we're at a rule boundary (CRLF followed by potential new rule or end of input)
   */
  isAtRuleBoundary(): boolean {
    if (!this.match(TokenKind.CRLF)) {
      return false;
    }

    // Look ahead past the CRLF to see if a new rule starts
    let pos = this.position + 1; // Skip the CRLF

    // If we're at the end, it's definitely a boundary
    if (pos >= this.tokens.length) {
      return true;
    }

    // Skip any whitespace/comments after CRLF
    while (pos < this.tokens.length &&
           (this.tokens[pos].kind === TokenKind.Whitespace || this.tokens[pos].kind === TokenKind.Comment)) {
      pos++;
    }

    // If we hit another CRLF or end of input, it's a boundary
    if (pos >= this.tokens.length || this.tokens[pos].kind === TokenKind.CRLF) {
      return true;
    }

    // If the next significant token is a rule name followed by =, it's a boundary
    if (pos < this.tokens.length && this.tokens[pos].kind === TokenKind.RuleName) {
      let nextPos = pos + 1;
      while (nextPos < this.tokens.length && this.tokens[nextPos].kind === TokenKind.Whitespace) {
        nextPos++;
      }

      return nextPos < this.tokens.length && this.tokens[nextPos].kind === TokenKind.Equal;
    }

    // Otherwise, it's a continuation line
    return false;
  }

  /**
   * Advances past any CRLF tokens, but only if they don't represent rule boundaries
   */
  skipContinuationLines(): void {
    while (this.match(TokenKind.CRLF) && !this.isAtRuleBoundary()) {
      this.moveNext();
      this.skipTrivia(); // Skip whitespace after CRLF on continuation lines
    }
  }

  private createEndOfInputToken(): Token {
    const lastToken = this.tokens.length > 0 ? this.tokens[this.tokens.length - 1] : null;
    return new Token(TokenKind.EndOfInput, '', lastToken?.line ?? 0, lastToken?.column ?? 0);
  }
}
