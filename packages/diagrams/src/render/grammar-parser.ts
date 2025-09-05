/**
 * Parser for the Grammar Definition Language
 */

import { GrammarRule, Expression, ExpressionType } from '../types';

export class GrammarParser {
  private input: string;
  private position: number;
  private allRuleNames: Set<string> = new Set();

  constructor(input: string) {
    this.input = input.trim();
    this.position = 0;
  }

  public parseGrammar(): GrammarRule[] {
    const rules: GrammarRule[] = [];
    const lines = this.input.split('\n');
    
    // First pass: collect all rule names
    for (const line of lines) {
      const trimmedLine = line.trim();
      if (trimmedLine && !trimmedLine.startsWith('//')) {
        const equalIndex = trimmedLine.indexOf('=');
        if (equalIndex !== -1) {
          const name = trimmedLine.substring(0, equalIndex).trim();
          this.allRuleNames.add(name);
        }
      }
    }
    
    // Second pass: parse rules with nonterminal knowledge
    for (const line of lines) {
      const trimmedLine = line.trim();
      if (trimmedLine && !trimmedLine.startsWith('//')) {
        const rule = this.parseRule(trimmedLine);
        if (rule) {
          rules.push(rule);
        }
      }
    }
    
    return rules;
  }

  private parseRule(line: string): GrammarRule | null {
    const equalIndex = line.indexOf('=');
    if (equalIndex === -1) return null;

    const name = line.substring(0, equalIndex).trim();
    const rhs = line.substring(equalIndex + 1).trim();

    const expression = this.parseExpression(rhs);
    return { name, expression };
  }

  private parseExpression(input: string): Expression {
    this.input = input;
    this.position = 0;
    return this.parseOperatorExpression();
  }

  private parseOperatorExpression(): Expression {
    this.skipWhitespace();
    
    // Check for operator keywords
    if (this.matchKeyword('inline')) {
      return this.parseOperator('inline');
    } else if (this.matchKeyword('stack')) {
      return this.parseOperator('stack');
    } else if (this.matchKeyword('bypass')) {
      return this.parseOperator('bypass');
    } else if (this.matchKeyword('loop')) {
      return this.parseOperator('loop');
    } else if (this.matchKeyword('group')) {
      return this.parseOperator('group');
    } else if (this.matchKeyword('lookahead')) {
      return this.parseOperator('lookahead');
    } else {
      return this.parseAtom();
    }
  }

  private parseOperator(type: ExpressionType): Expression {
    this.skipWhitespace();
    this.expect('(');
    
    const elements: Expression[] = [];
    
    while (!this.isAtEnd() && this.peek() !== ')') {
      this.skipWhitespace();
      if (this.peek() === ')') break;
      
      elements.push(this.parseOperatorExpression());
      
      this.skipWhitespace();
      if (this.peek() === ',') {
        this.advance();
        this.skipWhitespace();
      }
    }
    
    this.expect(')');
    
    return { type, elements };
  }

  private parseAtom(): Expression {
    this.skipWhitespace();
    
    if (this.peek() === '"') {
      return this.parseTerminal();
    } else if (this.peek() === '<') {
      return this.parseNonterminal();
    } else {
      // Handle regex patterns or simple identifiers as terminals
      return this.parseSimpleTerminal();
    }
  }

  private parseTerminal(): Expression {
    this.expect('"');
    let value = '';
    
    while (!this.isAtEnd() && this.peek() !== '"') {
      if (this.peek() === '\\') {
        // Keep the backslash for display in railroad diagrams
        value += this.advance();
        if (!this.isAtEnd()) {
          value += this.advance();
        }
      } else {
        value += this.advance();
      }
    }
    
    this.expect('"');
    return { type: 'terminal', value };
  }

  private parseNonterminal(): Expression {
    this.expect('<');
    let value = '';
    
    while (!this.isAtEnd() && this.peek() !== '>') {
      value += this.advance();
    }
    
    this.expect('>');
    return { type: 'nonterminal', value };
  }

  private parseSimpleTerminal(): Expression {
    let value = '';
    
    while (!this.isAtEnd() && 
           this.peek() !== ',' && 
           this.peek() !== ')' && 
           this.peek() !== '(' &&
           !this.isWhitespace(this.peek())) {
      value += this.advance();
    }
    
    // Check if this is actually a nonterminal (rule reference)
    if (this.allRuleNames.has(value)) {
      return { type: 'nonterminal', value };
    }
    
    return { type: 'terminal', value };
  }

  private matchKeyword(keyword: string): boolean {
    const saved = this.position;
    this.skipWhitespace();
    
    for (let i = 0; i < keyword.length; i++) {
      if (this.isAtEnd() || this.advance() !== keyword[i]) {
        this.position = saved;
        return false;
      }
    }
    
    // Make sure it's followed by whitespace or '('
    if (!this.isAtEnd() && !this.isWhitespace(this.peek()) && this.peek() !== '(') {
      this.position = saved;
      return false;
    }
    
    return true;
  }

  private skipWhitespace(): void {
    while (!this.isAtEnd() && this.isWhitespace(this.peek())) {
      this.advance();
    }
  }

  private isWhitespace(char: string): boolean {
    return /\s/.test(char);
  }

  private peek(): string {
    return this.isAtEnd() ? '\0' : this.input[this.position];
  }

  private advance(): string {
    return this.isAtEnd() ? '\0' : this.input[this.position++];
  }

  private expect(expected: string): void {
    if (this.peek() !== expected) {
      throw new Error(`Expected '${expected}' at position ${this.position}, got '${this.peek()}'`);
    }
    this.advance();
  }

  private isAtEnd(): boolean {
    return this.position >= this.input.length;
  }
}
