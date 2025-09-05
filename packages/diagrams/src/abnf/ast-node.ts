// ABNF Abstract Syntax Tree nodes - discriminated unions for type safety
// Based on the C# AstNode.cs implementation

export namespace AstNode {
  export interface RuleList {
    readonly kind: 'RuleList';
    readonly rules: Rule[];
  }

  export interface Rule {
    readonly kind: 'Rule';
    readonly name: string;
    readonly expression: Expression;
  }

  export type Expression =
    | Alternation
    | Concatenation
    | Repetition
    | Group
    | Option
    | RuleRef
    | Literal
    | NumberVal
    | ProseVal;

  export interface Alternation {
    readonly kind: 'Alternation';
    readonly options: Expression[];
  }

  export interface Concatenation {
    readonly kind: 'Concatenation';
    readonly elements: Expression[];
  }

  export interface Repetition {
    readonly kind: 'Repetition';
    readonly min?: number;
    readonly max?: number;
    readonly element: Expression;
  }

  export interface Group {
    readonly kind: 'Group';
    readonly inner: Expression;
  }

  export interface Option {
    readonly kind: 'Option';
    readonly inner: Expression;
  }

  export interface RuleRef {
    readonly kind: 'RuleRef';
    readonly name: string;
  }

  export interface Literal {
    readonly kind: 'Literal';
    readonly value: string;
    readonly isCaseSensitive: boolean;
  }

  export interface NumberVal {
    readonly kind: 'NumberVal';
    readonly value: string;
  }

  export interface ProseVal {
    readonly kind: 'ProseVal';
    readonly value: string;
  }
}

// Factory functions to create AST nodes
export const AstNode = {
  RuleList: (rules: AstNode.Rule[]): AstNode.RuleList => ({
    kind: 'RuleList',
    rules
  }),

  Rule: (name: string, expression: AstNode.Expression): AstNode.Rule => ({
    kind: 'Rule',
    name,
    expression
  }),

  Alternation: (options: AstNode.Expression[]): AstNode.Alternation => ({
    kind: 'Alternation',
    options
  }),

  Concatenation: (elements: AstNode.Expression[]): AstNode.Concatenation => ({
    kind: 'Concatenation',
    elements
  }),

  Repetition: (min: number | undefined, max: number | undefined, element: AstNode.Expression): AstNode.Repetition => ({
    kind: 'Repetition',
    min,
    max,
    element
  }),

  Group: (inner: AstNode.Expression): AstNode.Group => ({
    kind: 'Group',
    inner
  }),

  Option: (inner: AstNode.Expression): AstNode.Option => ({
    kind: 'Option',
    inner
  }),

  RuleRef: (name: string): AstNode.RuleRef => ({
    kind: 'RuleRef',
    name
  }),

  Literal: (value: string, isCaseSensitive: boolean): AstNode.Literal => ({
    kind: 'Literal',
    value,
    isCaseSensitive
  }),

  NumberVal: (value: string): AstNode.NumberVal => ({
    kind: 'NumberVal',
    value
  }),

  ProseVal: (value: string): AstNode.ProseVal => ({
    kind: 'ProseVal',
    value
  })
};
