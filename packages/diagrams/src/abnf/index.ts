// ABNF Parser and Transformer module
// Provides TypeScript implementation of ABNF parsing and railroad diagram transformation

export { TokenKind } from './token-kind.js';
export { Token } from './token.js';
export { Scanner } from './scanner.js';
export { TokenStream, SyntaxException } from './token-stream.js';
export { AstNode } from './ast-node.js';
export { Parser } from './parser.js';
export { RailroadTransformer } from './railroad-transformer.js';

import { Scanner } from './scanner.js';
import { Parser } from './parser.js';
import { RailroadTransformer } from './railroad-transformer.js';
import { AstNode } from './ast-node.js';

/**
 * Convenience function to parse ABNF text into railroad diagrams
 */
export function parseAbnfToRailroad(abnfText: string, fileName?: string): string {
  // Scan the input into tokens
  const tokens = Scanner.scan(abnfText);
  
  // Parse tokens into AST
  const parser = new Parser(tokens, fileName);
  const ruleList = parser.parseRuleList();
  
  // Transform AST to railroad format
  return RailroadTransformer.createRailroadDocument(ruleList);
}

/**
 * Parse ABNF text and return the AST for further processing
 */
export function parseAbnf(abnfText: string, fileName?: string): AstNode.RuleList {
  const tokens = Scanner.scan(abnfText);
  const parser = new Parser(tokens, fileName);
  return parser.parseRuleList();
}
