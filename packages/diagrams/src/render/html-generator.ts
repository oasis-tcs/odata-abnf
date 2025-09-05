/**
 * HTML Generator for Railroad Diagrams
 */

import { GrammarRule, DiagramOptions } from '../types';
import { SVGLayoutEngine } from './svg-layout-engine';

export class HTMLGenerator {
  private layoutEngine: SVGLayoutEngine;
  private options: DiagramOptions;

  constructor(options: DiagramOptions = {}) {
    this.options = options;
    this.layoutEngine = new SVGLayoutEngine(options);
  }

  public generateHTML(rules: GrammarRule[], filename?: string): string {
    const htmlParts: string[] = [];
    
    // Extract filename without extension for title
    const titleBase = filename 
      ? filename.replace(/\.[^/.]+$/, '') // Remove file extension
      : 'Railroad Diagram';
    const pageTitle = filename 
      ? `${titleBase} Railroad Diagrams`
      : 'Railroad Diagram';
    
    htmlParts.push(this.generateHeader(pageTitle));
    htmlParts.push(this.generateStyles());
    htmlParts.push('<body>');
    htmlParts.push('<div class="railroad-container">');
    htmlParts.push(`<h1>${pageTitle}</h1>`);
    htmlParts.push('<div class="rules-container">');

    for (const rule of rules) {
      htmlParts.push(this.generateRuleHTML(rule, rules));
    }

    htmlParts.push('</div>'); // rules-container
    htmlParts.push('</div>'); // railroad-container
    htmlParts.push(this.generateScript());
    htmlParts.push('</body>');
    htmlParts.push('</html>');

    return htmlParts.join('\n');
  }

  private generateHeader(title: string = 'Railroad Diagram'): string {
    return `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
</head>`;
  }

  private generateStyles(): string {
    return `<style>
    /* CSS Variables for railroad diagram customization */
    :root {
        --railroad-stroke-width: 5px;        /* Thickness of railroad paths */
        --railroad-box-stroke-width: 2px;    /* Thickness of terminal/nonterminal borders */
        --railroad-corner-radius: 12px;      /* Radius for rounded corners in paths */
        --railroad-stroke-color: #333;       /* Color of paths and borders */
        --railroad-terminal-fill: #f0f0f0;   /* Background color of terminals */
        --railroad-terminal-stroke: #333;    /* Border color of terminals */
        --railroad-nonterminal-fill: #e0e0e0; /* Background color of nonterminals */
        --railroad-nonterminal-stroke: #333; /* Border color of nonterminals */
    }
    
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #f5f5f5;
    }
    
    .railroad-container {
        max-width: 1200px;
        margin: 0 auto;
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    
    h1 {
        color: #333;
        text-align: center;
        margin-bottom: 30px;
    }
    
    .rules-container {
        display: flex;
        flex-direction: column;
        gap: 20px;
    }
    
    .rule-row {
        display: flex;
        align-items: flex-start;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 15px;
        background-color: #fafafa;
    }
    
    .rule-name {
        min-width: 200px;
        font-weight: bold;
        font-size: 16px;
        color: #333;
        padding-right: 20px;
        display: flex;
        align-items: center;
        margin-right: 20px;
    }
    
    .rule-diagram {
        flex: 1;
        min-height: 60px;
        display: flex;
        align-items: center;
    }
    
    .rule-diagram svg {
        max-width: 100%;
        height: auto;
    }
    
    /* Railroad diagram styling with CSS variables */
    .rule-diagram svg path {
        stroke: var(--railroad-stroke-color);
        stroke-width: var(--railroad-stroke-width);
    }
    
    .rule-diagram svg rect {
        stroke-width: var(--railroad-box-stroke-width);
    }
    
    .rule-diagram svg circle {
        fill: var(--railroad-stroke-color);
    }
    
    .nonterminal-link {
        cursor: pointer;
        text-decoration: underline;
        fill: #0066cc;
    }
    
    .nonterminal-link:hover {
        fill: #004499;
    }
    
    .rule-anchor {
        scroll-margin-top: 20px;
    }
    
    @media (max-width: 768px) {
        .rule-row {
            flex-direction: column;
        }
        
        .rule-name {
            margin-right: 0;
            margin-bottom: 15px;
            padding-bottom: 10px;
            min-width: auto;
        }
    }
</style>`;
  }

  private generateRuleHTML(rule: GrammarRule, allRules: GrammarRule[]): string {
    const layout = this.layoutEngine.layoutRuleRightHandSide(rule.expression);
    
    const svg = `<svg width="${layout.width}" height="${layout.height}" viewBox="0 0 ${layout.width} ${layout.height}">
    ${layout.svgContent}
</svg>`;

    return `<div class="rule-row rule-anchor" id="${this.escapeId(rule.name)}">
    <div class="rule-name">${this.escapeHtml(rule.name)}</div>
    <div class="rule-diagram">
        ${svg}
    </div>
</div>`;
  }

  private generateScript(): string {
    return `<script>
    // Add click handlers for nonterminal navigation
    document.addEventListener('DOMContentLoaded', function() {
        const nonterminals = document.querySelectorAll('[data-nonterminal]');
        
        nonterminals.forEach(function(element) {
            element.classList.add('nonterminal-link');
            element.addEventListener('click', function() {
                const nonterminal = this.getAttribute('data-nonterminal');
                const target = document.getElementById(nonterminal);
                
                if (target) {
                    target.scrollIntoView({ 
                        behavior: 'smooth',
                        block: 'center'
                    });
                    
                    // Highlight the target briefly
                    target.style.backgroundColor = '#ffffcc';
                    setTimeout(function() {
                        target.style.backgroundColor = '';
                    }, 2000);
                }
            });
        });
    });
</script>`;
  }

  private escapeHtml(text: string): string {
    return text
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&#39;');
  }

  private escapeId(text: string): string {
    return text.replace(/[^a-zA-Z0-9-_]/g, '_');
  }
}
