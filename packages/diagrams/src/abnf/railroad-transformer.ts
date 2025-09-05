import { AstNode } from './ast-node.js';
import { Expression } from '../types/grammar.js';

/**
 * Transforms ABNF AST nodes into our railroad diagram expression format
 * Based on the C# RailroadTransformer.cs implementation
 */
export class RailroadTransformer {
  /**
   * Transforms an ABNF RuleList into railroad diagram rules
   */
  static transformRuleList(ruleList: AstNode.RuleList): Array<{ name: string; expression: Expression }> {
    return ruleList.rules.map(rule => ({
      name: rule.name,
      expression: this.transformExpression(rule.expression)
    }));
  }

  /**
   * Transforms an ABNF expression into a railroad diagram expression
   */
  static transformExpression(expr: AstNode.Expression): Expression {
    switch (expr.kind) {
      case 'Alternation':
        return this.transformAlternation(expr);
      
      case 'Concatenation':
        return this.transformConcatenation(expr);
      
      case 'Repetition':
        return this.transformRepetition(expr);
      
      case 'Group':
        return this.transformGroup(expr);
      
      case 'Option':
        return this.transformOption(expr);
      
      case 'RuleRef':
        return this.transformRuleRef(expr);
      
      case 'Literal':
        return this.transformLiteral(expr);
      
      case 'NumberVal':
        return this.transformNumberVal(expr);
      
      case 'ProseVal':
        return this.transformProseVal(expr);
      
      default:
        // TypeScript should catch this, but just in case
        throw new Error(`Unknown expression kind: ${(expr as any).kind}`);
    }
  }

  private static transformAlternation(expr: AstNode.Alternation): Expression {
    if (expr.options.length === 1) {
      return this.transformExpression(expr.options[0]);
    }
    
    return {
      type: 'stack', // alternation maps to stack layout
      elements: expr.options.map(option => this.transformExpression(option))
    };
  }

  private static transformConcatenation(expr: AstNode.Concatenation): Expression {
    if (expr.elements.length === 1) {
      return this.transformExpression(expr.elements[0]);
    }
    
    return {
      type: 'inline', // concatenation maps to inline layout
      elements: expr.elements.map(element => this.transformExpression(element))
    };
  }

  private static transformRepetition(expr: AstNode.Repetition): Expression {
    const inner = this.transformExpression(expr.element);
    
    // Handle different repetition patterns
    if (expr.min === 0 && expr.max === 1) {
      // 0*1 is optional
      return {
        type: 'bypass', // option maps to bypass layout
        elements: [inner]
      };
    }
    
    if (expr.min === 0 && (expr.max === undefined || expr.max > 1)) {
      // 0*n or 0* is zero or more (optional loop)
      return {
        type: 'bypass', // optional
        elements: [{
          type: 'loop', // with loop
          elements: [inner]
        }]
      };
    }
    
    if (expr.min === 1 && (expr.max === undefined || expr.max > 1)) {
      // 1*n or 1* is one or more
      return {
        type: 'loop', // repetition maps to loop layout
        elements: [inner]
      };
    }
    
    if (expr.min !== undefined && expr.min > 1 && expr.max === expr.min) {
      // n*n is exactly n times - create inline repetition
      const elements = Array(expr.min).fill(null).map(() => inner);
      return {
        type: 'inline',
        elements
      };
    }
    
    // For other complex repetitions, use a prose description
    const minStr = expr.min !== undefined ? expr.min.toString() : '';
    const maxStr = expr.max !== undefined ? expr.max.toString() : '';
    const repetitionDesc = `${minStr}*${maxStr}`;
    
    return {
      type: 'group',
      elements: [{
        type: 'inline',
        elements: [
          {
            type: 'terminal',
            value: `<${repetitionDesc} times>`
          },
          inner
        ]
      }]
    };
  }

  private static transformGroup(expr: AstNode.Group): Expression {
    return {
      type: 'group', // group maps to group layout
      elements: [this.transformExpression(expr.inner)]
    };
  }

  private static transformOption(expr: AstNode.Option): Expression {
    return {
      type: 'bypass', // option maps to bypass layout
      elements: [this.transformExpression(expr.inner)]
    };
  }

  private static transformRuleRef(expr: AstNode.RuleRef): Expression {
    return {
      type: 'nonterminal',
      value: expr.name
    };
  }

  private static transformLiteral(expr: AstNode.Literal): Expression {
    // Remove surrounding quotes and use the literal value
    let value = expr.value;
    if (value.length >= 2 && (value.startsWith('"') || value.startsWith("'"))) {
      value = value.slice(1, -1);
    }
    
    return {
      type: 'terminal',
      value: value
    };
  }

  private static transformNumberVal(expr: AstNode.NumberVal): Expression {
    // For now, treat number values as terminals with their raw representation
    // In a more sophisticated implementation, we might decode them
    return {
      type: 'terminal',
      value: expr.value
    };
  }

  private static transformProseVal(expr: AstNode.ProseVal): Expression {
    // Prose values are typically descriptive text in angle brackets
    return {
      type: 'terminal',
      value: expr.value
    };
  }

  /**
   * Creates a complete railroad document from an ABNF rule list
   */
  static createRailroadDocument(ruleList: AstNode.RuleList): string {
    const rules = this.transformRuleList(ruleList);
    
    // Convert to our railroad syntax
    const ruleStrings = rules.map(rule => {
      const exprString = this.expressionToString(rule.expression);
      return `${rule.name} = ${exprString}`;
    });
    
    return ruleStrings.join('\n\n');
  }

  /**
   * Converts a railroad expression to string representation
   */
  private static expressionToString(expr: Expression): string {
    switch (expr.type) {
      case 'terminal':
        return `"${expr.value}"`;
      
      case 'nonterminal':
        return `<${expr.value}>`;
      
      case 'inline':
        if (!expr.elements) return '';
        const inlineElements = expr.elements.map(e => this.expressionToString(e));
        return `inline(${inlineElements.join(', ')})`;
      
      case 'stack':
        if (!expr.elements) return '';
        const stackElements = expr.elements.map(e => this.expressionToString(e));
        return `stack(${stackElements.join(', ')})`;
      
      case 'bypass':
        if (!expr.elements || expr.elements.length === 0) return '';
        return `bypass(${this.expressionToString(expr.elements[0])})`;
      
      case 'loop':
        if (!expr.elements || expr.elements.length === 0) return '';
        return `loop(${this.expressionToString(expr.elements[0])})`;
      
      case 'group':
        if (!expr.elements || expr.elements.length === 0) return '';
        return `group(${this.expressionToString(expr.elements[0])})`;
      
      default:
        return `<unknown: ${(expr as any).type}>`;
    }
  }
}
