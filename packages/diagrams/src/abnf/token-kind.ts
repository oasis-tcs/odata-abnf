// Token kinds for ABNF parsing - matches C# implementation
export enum TokenKind {
  Repeat = 'Repeat',                               // e.g. 1*2, 1*, *2, * (standalone)
  Integer = 'Integer',                             // e.g. 1, 42
  Whitespace = 'Whitespace',
  Comment = 'Comment',
  CRLF = 'CRLF',
  RuleName = 'RuleName',
  CharVal = 'CharVal',                             // double quoted string (case-insensitive, RFC 5234)
  CaseSensitiveCharVal = 'CaseSensitiveCharVal',   // single quoted string (case-sensitive, RFC 7405)
  CaseInsensitiveStringVal = 'CaseInsensitiveStringVal', // %i"..." (case-insensitive, RFC 7405)
  CaseSensitiveStringVal = 'CaseSensitiveStringVal',     // %s"..." (case-sensitive, RFC 7405)
  ProseVal = 'ProseVal',                           // <...>
  NumVal = 'NumVal',                               // percent notation, e.g. %x0D.0A
  ValueRange = 'ValueRange',                       // value range notation, e.g. %x41-5A
  Equal = 'Equal',
  Slash = 'Slash',
  OpenParen = 'OpenParen',
  CloseParen = 'CloseParen',
  OpenBracket = 'OpenBracket',
  CloseBracket = 'CloseBracket',
  OpenAngle = 'OpenAngle',
  CloseAngle = 'CloseAngle',
  Percent = 'Percent',
  OtherSymbol = 'OtherSymbol',
  EndOfInput = 'EndOfInput'
}
