import { TokenKind } from './token-kind.js';

export class Token {
  constructor(
    public readonly kind: TokenKind,
    public readonly value: string,
    public readonly line: number,
    public readonly column: number
  ) {}

  /**
   * Decodes the value of a Literal, NumberVal (percent notation), or ValueRange token to a string.
   * Throws if not a supported kind.
   */
  stringValue(): string {
    if (this.kind === TokenKind.CharVal || this.kind === TokenKind.CaseSensitiveCharVal) {
      // Remove surrounding quotes (single or double)
      if (this.value.length >= 2 && (this.value[0] === '"' || this.value[0] === "'")) {
        return this.value.substring(1, this.value.length - 1);
      }
      return this.value;
    }

    if (this.kind === TokenKind.CaseInsensitiveStringVal || this.kind === TokenKind.CaseSensitiveStringVal) {
      // RFC 7405: %i"..." or %s"..." - remove %i" or %s" prefix and trailing quote
      if (this.value.length >= 4 && this.value.startsWith('%') && this.value[2] === '"' && this.value.endsWith('"')) {
        return this.value.substring(3, this.value.length - 1);
      }
      return this.value;
    }

    if (this.kind === TokenKind.NumVal) {
      // Only support %x... (hex) for now
      if (this.value.length < 3 || (this.value[0] !== '%' || this.value[1].toLowerCase() !== 'x')) {
        throw new Error(`Only %x... notation is supported: ${this.value}`);
      }
      const bytes = this.value.substring(2).split('.');
      const chars = new Array<string>(bytes.length);
      for (let i = 0; i < bytes.length; i++) {
        if (bytes[i].length === 0) {
          throw new Error(`Empty byte in percent notation: ${this.value}`);
        }
        const code = parseInt(bytes[i], 16);
        chars[i] = String.fromCharCode(code);
      }
      return chars.join('');
    }

    if (this.kind === TokenKind.ValueRange) {
      // Return the raw value for now; decoding a range is not meaningful as a string
      return this.value;
    }

    throw new Error(`Token is not a CharVal, NumVal, or ValueRange: ${this.kind}`);
  }

  toString(): string {
    return `${this.kind} '${this.value}' @ ${this.line}:${this.column}`;
  }
}
