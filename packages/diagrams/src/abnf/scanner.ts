import { Token } from './token.js';
import { TokenKind } from './token-kind.js';

export class Scanner {
  // Single regex with mutually exclusive named groups - matches C# implementation
  private static readonly TOKEN_REGEX = new RegExp(
    [
      '(?<Whitespace>[ \\t]+)',
      '(?<Comment>;[^\\r\\n]*)',
      '(?<CRLF>\\r\\n|\\n|\\r)',
      '(?<RuleName>[A-Za-z][A-Za-z0-9-]*)',
      '(?<Repeat>([0-9]+\\*[0-9]*|[0-9]+\\*|\\*[0-9]+|\\*))',  // Covers all repetition patterns including standalone *
      '(?<Integer>[0-9]+)(?!\\*)',
      '(?<CaseInsensitiveStringVal>%[iI]"[^"]*")',  // RFC 7405: %i"..." case-insensitive
      '(?<CaseSensitiveStringVal>%[sS]"[^"]*")',    // RFC 7405: %s"..." case-sensitive
      '(?<CharVal>"[^"]*")',
      '(?<CaseSensitiveCharVal>\'[^\']*\')',
      '(?<ProseVal><[^>]*>)',
      '(?<ValueRange>%[bBdDxX][0-9A-Fa-f]+-[0-9A-Fa-f]+)',
      '(?<NumVal>%[bBdDxX][0-9A-Fa-f]+(?:\\.[0-9A-Fa-f]+)*)',
      '(?<Equal>=)',
      '(?<Slash>/)',
      '(?<OpenParen>\\()',
      '(?<CloseParen>\\))',
      '(?<OpenBracket>\\[)',
      '(?<CloseBracket>\\])',
      '(?<OpenAngle><)',
      '(?<CloseAngle>>)',
      '(?<Percent>%)(?![bBdDxXiIsS])',
      '(?<OtherSymbol>[-])'
    ].join('|'),
    'gm'
  );

  static scan(input: string): Token[] {
    const tokens: Token[] = [];
    let line = 1;
    let col = 1;
    let pos = 0;

    this.TOKEN_REGEX.lastIndex = 0; // Reset regex state
    let match = this.TOKEN_REGEX.exec(input);

    while (match) {
      // Find which named group matched
      let matchedGroup: string | null = null;
      let matchedValue: string | null = null;

      for (const [groupName, groupValue] of Object.entries(match.groups || {})) {
        if (groupValue !== undefined) {
          matchedGroup = groupName;
          matchedValue = groupValue;
          break;
        }
      }

      if (matchedGroup && matchedValue !== null) {
        // Convert group name to TokenKind
        const tokenKind = this.getTokenKind(matchedGroup);
        tokens.push(new Token(tokenKind, matchedValue, line, col));

        // Update position tracking
        for (let i = 0; i < matchedValue.length; i++) {
          if (matchedValue[i] === '\n') {
            line++;
            col = 1;
          } else if (matchedValue[i] !== '\r') {
            col++;
          }
        }
        pos += matchedValue.length;
      }

      match = this.TOKEN_REGEX.exec(input);
    }

    // Add EndOfInput token
    tokens.push(new Token(TokenKind.EndOfInput, '', line, col));
    return tokens;
  }

  private static getTokenKind(groupName: string): TokenKind {
    // Map group names to TokenKind enum values
    switch (groupName) {
      case 'Whitespace': return TokenKind.Whitespace;
      case 'Comment': return TokenKind.Comment;
      case 'CRLF': return TokenKind.CRLF;
      case 'RuleName': return TokenKind.RuleName;
      case 'Repeat': return TokenKind.Repeat;
      case 'Integer': return TokenKind.Integer;
      case 'CharVal': return TokenKind.CharVal;
      case 'CaseSensitiveCharVal': return TokenKind.CaseSensitiveCharVal;
      case 'CaseInsensitiveStringVal': return TokenKind.CaseInsensitiveStringVal;
      case 'CaseSensitiveStringVal': return TokenKind.CaseSensitiveStringVal;
      case 'ProseVal': return TokenKind.ProseVal;
      case 'ValueRange': return TokenKind.ValueRange;
      case 'NumVal': return TokenKind.NumVal;
      case 'Equal': return TokenKind.Equal;
      case 'Slash': return TokenKind.Slash;
      case 'OpenParen': return TokenKind.OpenParen;
      case 'CloseParen': return TokenKind.CloseParen;
      case 'OpenBracket': return TokenKind.OpenBracket;
      case 'CloseBracket': return TokenKind.CloseBracket;
      case 'OpenAngle': return TokenKind.OpenAngle;
      case 'CloseAngle': return TokenKind.CloseAngle;
      case 'Percent': return TokenKind.Percent;
      case 'OtherSymbol': return TokenKind.OtherSymbol;
      default: return TokenKind.OtherSymbol;
    }
  }
}
