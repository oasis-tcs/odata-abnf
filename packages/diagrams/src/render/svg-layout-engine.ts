/**
 * SVG Layout Engine for Railroad Diagrams
 */

import { Expression, LayoutResult, Point, DiagramOptions } from '../types';

export class SVGLayoutEngine {
  private options: Required<DiagramOptions>;

  constructor(options: Partial<DiagramOptions> = {}) {
    this.options = {
      padding: 20,
      strokeWidth: 5,
      fontSize: 14,
      fontFamily: 'Arial, sans-serif',
      cornerRadius: 16,
      minRailWidth: 40,
      debug: false,
      terminalStyle: {
        fill: '#f0f0f0',
        stroke: '#333',
        fontWeight: 'bold',
      },
      nonterminalStyle: {
        fill: '#e0e0e0',
        stroke: '#333',
        fontWeight: 'normal',
      },
      ...options,
    };
  }

  public layout(expression: Expression): LayoutResult {
    const result = this.layoutExpression(expression, 0, 0);
    
    // Add top-level debug visualization if enabled
    if (this.options.debug) {
      result.svgContent = result.svgContent + this.createDebugVisualization(result.width, result.height, result.baseline, 0, 0);
    }
    
    return result;
  }

  public layoutRuleRightHandSide(expression: Expression): LayoutResult {
    // First get the core expression layout
    const coreResult = this.layout(expression);
    
    // Add lead-in/out paths and start/end connectors to the total dimensions
    const leadLength = 30;
    const sideMargin = 20;
    const circleRadius = Math.max(this.options.strokeWidth * 1.5, 6);
    
    // Use smaller pink circles in debug mode, normal gray circles otherwise
    const debugCircleRadius = this.options.debug ? 3 : circleRadius;
    const circleColor = this.options.debug ? 'hotpink' : '#333';
    
    const totalWidth = coreResult.width + (leadLength * 2) + (sideMargin * 2);
    const totalHeight = coreResult.height + 40; // Top/bottom padding
    const adjustedBaseline = coreResult.baseline + 20; // Account for top padding
    
    // Create the complete SVG with lead paths and connectors
    const startConnector = `<circle cx="${sideMargin}" cy="${adjustedBaseline}" r="${debugCircleRadius}" fill="${circleColor}"/>`;
    const endConnector = `<circle cx="${totalWidth - sideMargin}" cy="${adjustedBaseline}" r="${debugCircleRadius}" fill="${circleColor}"/>`;
    
    const startLeadPath = `<path d="M ${sideMargin} ${adjustedBaseline} L ${sideMargin + leadLength} ${adjustedBaseline}" 
             fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`;
    
    const startPath = coreResult.connectorLeft ? 
      `<path d="M ${sideMargin + leadLength} ${adjustedBaseline} L ${coreResult.connectorLeft.x + sideMargin + leadLength} ${coreResult.connectorLeft.y + 20}" 
             fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>` : '';
    
    const endPath = coreResult.connectorRight ? 
      `<path d="M ${coreResult.connectorRight.x + sideMargin + leadLength} ${coreResult.connectorRight.y + 20} L ${totalWidth - sideMargin - leadLength} ${adjustedBaseline}" 
             fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>` : '';
             
    const endLeadPath = `<path d="M ${totalWidth - sideMargin - leadLength} ${adjustedBaseline} L ${totalWidth - sideMargin} ${adjustedBaseline}" 
             fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`;

    const completeSvg = `<g transform="translate(${sideMargin + leadLength}, 20)">
        ${coreResult.svgContent}
    </g>
    ${startConnector}
    ${endConnector}
    ${startLeadPath}
    ${startPath}
    ${endPath}
    ${endLeadPath}`;
    
    // Add top-level debug visualization if enabled (for the complete rule)
    const finalSvg = this.options.debug ? 
      completeSvg + this.createDebugVisualization(totalWidth, totalHeight, adjustedBaseline, 0, 0) :
      completeSvg;
    
    return {
      width: totalWidth,
      height: totalHeight,
      baseline: adjustedBaseline,
      svgContent: finalSvg,
      connectorLeft: { x: sideMargin, y: adjustedBaseline },
      connectorRight: { x: totalWidth - sideMargin, y: adjustedBaseline },
    };
  }

  public getStrokeWidth(): number {
    return this.options.strokeWidth;
  }

  private layoutExpression(expression: Expression, x: number, y: number): LayoutResult {
    // First, layout the expression content at origin to get dimensions
    let contentResult: LayoutResult;
    
    switch (expression.type) {
      case 'terminal':
        contentResult = this.layoutTerminalContent(expression);
        break;
      case 'nonterminal':
        contentResult = this.layoutNonterminalContent(expression);
        break;
      case 'inline':
        contentResult = this.layoutInlineContent(expression);
        break;
      case 'stack':
        contentResult = this.layoutStackContent(expression);
        break;
      case 'bypass':
        contentResult = this.layoutBypassContent(expression);
        break;
      case 'loop':
        contentResult = this.layoutLoopContent(expression);
        break;
      case 'group':
        contentResult = this.layoutGroupContent(expression);
        break;
      default:
        throw new Error(`Unknown expression type: ${expression.type}`);
    }

    // Wrap the content in a positioned group
    const groupSvg = `<g transform="translate(${x}, ${y})" class="${expression.type}-node">${contentResult.svgContent}</g>`;
    
    return {
      width: contentResult.width,
      height: contentResult.height,
      baseline: y + contentResult.baseline, // Adjust baseline to world coordinates
      svgContent: groupSvg,
      connectorLeft: { x: x + contentResult.connectorLeft.x, y: y + contentResult.connectorLeft.y },
      connectorRight: { x: x + contentResult.connectorRight.x, y: y + contentResult.connectorRight.y },
    };
  }

  private layoutTerminalContent(expression: Expression): LayoutResult {
    const rawText = expression.value === ' ' ? '\u00A0' : (expression.value || '');
    const text = `"${rawText}"`;  // Add quotes around terminal values for visual clarity
    const textWidth = this.measureText(text);
    const boxWidth = textWidth + this.options.padding;
    const boxHeight = this.options.fontSize + this.options.padding;
    const baseline = boxHeight / 2;
    
    // Add minimal rail width to ensure there's always some rail visible
    const totalWidth = Math.max(boxWidth + this.options.minRailWidth, boxWidth);
    const railPadding = (totalWidth - boxWidth) / 2;
    const boxX = railPadding;
    
    // Position text at the exact center of the box
    const textY = boxHeight / 2;

    const svgContent = [
      this.createRoundedRect(boxX, 0, boxWidth, boxHeight, this.options.terminalStyle),
      this.createText(boxX + boxWidth / 2, textY, text, {
        textAnchor: 'middle',
        dominantBaseline: 'central',
        fontWeight: this.options.terminalStyle.fontWeight,
      }),
    ];

    // Add connecting rails as a single continuous path if there's rail padding
    if (railPadding > 0) {
      // Combine both rail segments into a single path for seamless rendering
      svgContent.push(
        `<path d="M 0 ${baseline} L ${boxX} ${baseline} M ${boxX + boxWidth} ${baseline} L ${totalWidth} ${baseline}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`
      );
    } else {
      // Even when no rail padding, ensure connection points are connected to box edges
      svgContent.push(
        `<path d="M 0 ${baseline} L ${boxX} ${baseline}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`
      );
      svgContent.push(
        `<path d="M ${boxX + boxWidth} ${baseline} L ${totalWidth} ${baseline}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`
      );
    }

    return {
      width: totalWidth,
      height: boxHeight,
      baseline,
      svgContent: this.wrapWithDebug(svgContent.join(''), totalWidth, boxHeight, baseline),
      connectorLeft: { x: 0, y: baseline },
      connectorRight: { x: totalWidth, y: baseline },
    };
  }

  private layoutNonterminalContent(expression: Expression): LayoutResult {
    const text = expression.value || '';
    const textWidth = this.measureText(text);
    const boxWidth = textWidth + this.options.padding;
    const boxHeight = this.options.fontSize + this.options.padding;
    const baseline = boxHeight / 2;
    
    // Add minimal rail width to ensure there's always some rail visible
    const totalWidth = Math.max(boxWidth + this.options.minRailWidth, boxWidth);
    const railPadding = (totalWidth - boxWidth) / 2;
    const boxX = railPadding;
    
    // Position text at the exact center of the box
    const textY = boxHeight / 2;

    const svgContent = [
      this.createRoundedRect(boxX, 0, boxWidth, boxHeight, this.options.nonterminalStyle),
      this.createText(boxX + boxWidth / 2, textY, text, {
        textAnchor: 'middle',
        dominantBaseline: 'central',
        fontWeight: this.options.nonterminalStyle.fontWeight,
        cursor: 'pointer',
        'data-nonterminal': expression.value,
      }),
    ];

    // Add connecting rails as a single continuous path if there's rail padding
    if (railPadding > 0) {
      // Combine both rail segments into a single path for seamless rendering
      svgContent.push(
        `<path d="M 0 ${baseline} L ${boxX} ${baseline} M ${boxX + boxWidth} ${baseline} L ${totalWidth} ${baseline}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`
      );
    } else {
      // Even when no rail padding, ensure connection points are connected to box edges
      svgContent.push(
        `<path d="M 0 ${baseline} L ${boxX} ${baseline}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`
      );
      svgContent.push(
        `<path d="M ${boxX + boxWidth} ${baseline} L ${totalWidth} ${baseline}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`
      );
    }

    return {
      width: totalWidth,
      height: boxHeight,
      baseline,
      svgContent: this.wrapWithDebug(svgContent.join(''), totalWidth, boxHeight, baseline),
      connectorLeft: { x: 0, y: baseline },
      connectorRight: { x: totalWidth, y: baseline },
    };
  }

  private layoutInlineContent(expression: Expression): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return {
        width: 0,
        height: 0,
        baseline: 0,
        svgContent: '',
        connectorLeft: { x: 0, y: 0 },
        connectorRight: { x: 0, y: 0 },
      };
    }

    // Layout each child element at origin to get their dimensions and baselines
    const childResults: LayoutResult[] = [];
    for (const element of elements) {
      let result: LayoutResult;
      switch (element.type) {
        case 'terminal':
          result = this.layoutTerminalContent(element);
          break;
        case 'nonterminal':
          result = this.layoutNonterminalContent(element);
          break;
        case 'inline':
          result = this.layoutInlineContent(element);
          break;
        case 'stack':
          result = this.layoutStackContent(element);
          break;
        case 'bypass':
          result = this.layoutBypassContent(element);
          break;
        case 'loop':
          result = this.layoutLoopContent(element);
          break;
        case 'group':
          result = this.layoutGroupContent(element);
          break;
        default:
          throw new Error(`Unknown expression type: ${(element as any).type}`);
      }
      childResults.push(result);
    }

    // Find the common baseline (use the maximum baseline to accommodate all elements)
    const commonBaseline = Math.max(...childResults.map(r => r.baseline));

    // Calculate positions for each child based on baseline alignment
    let currentX = 0;
    const svgParts: string[] = [];
    
    for (let i = 0; i < childResults.length; i++) {
      const child = childResults[i];
      
      // Calculate Y offset to align child's baseline with common baseline
      const childY = commonBaseline - child.baseline;
      
      // Wrap child SVG in a translated group
      const translatedSvg = `<g transform="translate(${currentX}, ${childY})">${child.svgContent}</g>`;
      svgParts.push(translatedSvg);
      
      // Add connecting line to next element (if not last)
      if (i < childResults.length - 1) {
        const lineStart = { x: currentX + child.width, y: commonBaseline };
        const lineEnd = { x: currentX + child.width + this.options.padding, y: commonBaseline };
        svgParts.push(this.createPath([lineStart, lineEnd]));
      }
      
      currentX += child.width + this.options.padding;
    }

    // Calculate final dimensions
    const totalWidth = currentX - this.options.padding;
    const minY = Math.min(...childResults.map(r => commonBaseline - r.baseline));
    const maxY = Math.max(...childResults.map(r => commonBaseline - r.baseline + r.height));
    const totalHeight = maxY - minY;

    return {
      width: totalWidth,
      height: totalHeight,
      baseline: commonBaseline,
      svgContent: this.wrapWithDebug(svgParts.join(''), totalWidth, totalHeight, commonBaseline),
      connectorLeft: { x: 0, y: commonBaseline },
      connectorRight: { x: totalWidth, y: commonBaseline },
    };
  }

  private layoutStackContent(expression: Expression): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return {
        width: 0,
        height: 0,
        baseline: 0,
        svgContent: '',
        connectorLeft: { x: 0, y: 0 },
        connectorRight: { x: 0, y: 0 },
      };
    }

    let maxWidth = 0;
    let totalHeight = 0;
    const results: LayoutResult[] = [];
    
    // Layout all alternatives at origin
    for (const element of elements) {
      let result: LayoutResult;
      switch (element.type) {
        case 'terminal':
          result = this.layoutTerminalContent(element);
          break;
        case 'nonterminal':
          result = this.layoutNonterminalContent(element);
          break;
        case 'inline':
          result = this.layoutInlineContent(element);
          break;
        case 'stack':
          result = this.layoutStackContent(element);
          break;
        case 'bypass':
          result = this.layoutBypassContent(element);
          break;
        case 'loop':
          result = this.layoutLoopContent(element);
          break;
        case 'group':
          result = this.layoutGroupContent(element);
          break;
        default:
          throw new Error(`Unknown expression type: ${(element as any).type}`);
      }
      results.push(result);
      maxWidth = Math.max(maxWidth, result.width);
      totalHeight += result.height + this.options.padding;
    }
    
    totalHeight += this.options.padding; // Add top padding
    maxWidth += this.options.padding * 4; // Add side padding
    
    // Calculate proper baseline - use middle element's baseline for odd counts
    let externalBaseline: number;
    if (results.length % 2 === 1) {
      // Odd number of elements - use middle element's baseline
      const middleIndex = Math.floor(results.length / 2);
      let middleY = this.options.padding;
      for (let i = 0; i < middleIndex; i++) {
        middleY += results[i].height + this.options.padding;
      }
      externalBaseline = middleY + results[middleIndex].baseline;
    } else {
      // Even number of elements - use geometric center
      externalBaseline = totalHeight / 2;
    }
    
    const svgParts: string[] = [];
    
    // Ensure minimum distance between connection points and child elements
    const minConnectionDistance = Math.max(this.options.padding, 20);

    // Add all element SVGs at their calculated positions
    let currentY = this.options.padding;
    for (let i = 0; i < results.length; i++) {
      const result = results[i];
      
      // Center each child horizontally within the available space
      const availableWidth = maxWidth - (2 * minConnectionDistance);
      const childX = minConnectionDistance + (availableWidth - result.width) / 2;
      
      const translatedSvg = `<g transform="translate(${childX}, ${currentY})">${result.svgContent}</g>`;
      svgParts.push(translatedSvg);
      
      // Add choice paths
      const elementBaseline = currentY + result.baseline;
      
      // Check if this is the middle element for odd-numbered stacks
      const isMiddleElement = results.length % 2 === 1 && i === Math.floor(results.length / 2);
      
      const leftConnectionX = childX;
      const rightConnectionX = childX + result.width;
      
      if (isMiddleElement || Math.abs(elementBaseline - externalBaseline) <= 2) {
        // Draw horizontal paths for middle element or elements on the external baseline
        svgParts.push(
          this.createPath([
            { x: 0, y: externalBaseline },
            { x: leftConnectionX, y: externalBaseline },
          ])
        );
        svgParts.push(
          this.createPath([
            { x: rightConnectionX, y: externalBaseline },
            { x: maxWidth, y: externalBaseline },
          ])
        );
      } else {
        // Draw paths with vertical segments for elements not on the baseline
        svgParts.push(
          this.createPath([
            { x: 0, y: externalBaseline },
            { x: minConnectionDistance / 2, y: externalBaseline },
            { x: minConnectionDistance / 2, y: elementBaseline },
            { x: leftConnectionX, y: elementBaseline },
          ])
        );
        svgParts.push(
          this.createPath([
            { x: rightConnectionX, y: elementBaseline },
            { x: maxWidth - (minConnectionDistance / 2), y: elementBaseline },
            { x: maxWidth - (minConnectionDistance / 2), y: externalBaseline },
            { x: maxWidth, y: externalBaseline },
          ])
        );
      }
      
      currentY += result.height + this.options.padding;
    }

    return {
      width: maxWidth,
      height: totalHeight,
      baseline: externalBaseline,
      svgContent: this.wrapWithDebug(svgParts.join(''), maxWidth, totalHeight, externalBaseline),
      connectorLeft: { x: 0, y: externalBaseline },
      connectorRight: { x: maxWidth, y: externalBaseline },
    };
  }

  private layoutBypassContent(expression: Expression): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return {
        width: 0,
        height: 0,
        baseline: 0,
        svgContent: '',
        connectorLeft: { x: 0, y: 0 },
        connectorRight: { x: 0, y: 0 },
      };
    }

    // Layout child at origin to get dimensions
    const element = elements[0];
    let childResult: LayoutResult;
    switch (element.type) {
      case 'terminal':
        childResult = this.layoutTerminalContent(element);
        break;
      case 'nonterminal':
        childResult = this.layoutNonterminalContent(element);
        break;
      case 'inline':
        childResult = this.layoutInlineContent(element);
        break;
      case 'stack':
        childResult = this.layoutStackContent(element);
        break;
      case 'bypass':
        childResult = this.layoutBypassContent(element);
        break;
      case 'loop':
        childResult = this.layoutLoopContent(element);
        break;
      case 'group':
        childResult = this.layoutGroupContent(element);
        break;
      default:
        throw new Error(`Unknown expression type: ${(element as any).type}`);
    }

    const totalWidth = childResult.width + this.options.padding * 2;
    
    // Calculate the bypass position relative to the child's actual dimensions and baseline
    const bypassOffset = this.options.padding; // Reduced from 1.5x to 1x padding for tighter layout
    
    // Calculate if bypass should go above or below based on child's actual layout
    const spaceAbove = childResult.baseline;
    const spaceBelow = childResult.height - childResult.baseline;
    const bypassBelow = spaceBelow >= spaceAbove;
    
    // Position child and calculate external baseline and bypass Y
    const childX = this.options.padding;
    const childY = this.options.padding;
    const externalBaseline = childY + childResult.baseline;
    
    // Calculate bypass Y position and total height based on child's actual layout
    let bypassY: number;
    let totalHeight: number;
    
    if (bypassBelow) {
      // Bypass goes below the child element
      bypassY = childY + childResult.height + bypassOffset;
      totalHeight = bypassY + this.options.padding; // Just bypass position + minimal bottom padding
    } else {
      // Bypass goes above the child element  
      bypassY = childY - bypassOffset;
      totalHeight = childY + childResult.height + this.options.padding; // Child bottom + minimal padding
    }
    
    const svgParts: string[] = [];

    // Add positioned child content
    svgParts.push(`<g transform="translate(${childX}, ${childY})">${childResult.svgContent}</g>`);

    // Bypass path with proper curves
    const bypassPath = [
      { x: 0, y: externalBaseline },
      { x: this.options.padding / 2, y: externalBaseline },
      { x: this.options.padding / 2, y: bypassY },
      { x: totalWidth - this.options.padding / 2, y: bypassY },
      { x: totalWidth - this.options.padding / 2, y: externalBaseline },
      { x: totalWidth, y: externalBaseline },
    ];
    svgParts.push(this.createPath(bypassPath));

    // Main path (through the element)
    const mainPath = [
      { x: 0, y: externalBaseline },
      { x: this.options.padding, y: externalBaseline },
    ];
    svgParts.push(this.createPath(mainPath));

    const exitPath = [
      { x: this.options.padding + childResult.width, y: externalBaseline },
      { x: totalWidth, y: externalBaseline },
    ];
    svgParts.push(this.createPath(exitPath));

    return {
      width: totalWidth,
      height: totalHeight,
      baseline: externalBaseline,
      svgContent: this.wrapWithDebug(svgParts.join(''), totalWidth, totalHeight, externalBaseline),
      connectorLeft: { x: 0, y: externalBaseline },
      connectorRight: { x: totalWidth, y: externalBaseline },
    };
  }

  private layoutLoopContent(expression: Expression): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return {
        width: 0,
        height: 0,
        baseline: 0,
        svgContent: '',
        connectorLeft: { x: 0, y: 0 },
        connectorRight: { x: 0, y: 0 },
      };
    }

    // Layout child at origin to get dimensions
    const element = elements[0];
    let childResult: LayoutResult;
    switch (element.type) {
      case 'terminal':
        childResult = this.layoutTerminalContent(element);
        break;
      case 'nonterminal':
        childResult = this.layoutNonterminalContent(element);
        break;
      case 'inline':
        childResult = this.layoutInlineContent(element);
        break;
      case 'stack':
        childResult = this.layoutStackContent(element);
        break;
      case 'bypass':
        childResult = this.layoutBypassContent(element);
        break;
      case 'loop':
        childResult = this.layoutLoopContent(element);
        break;
      case 'group':
        childResult = this.layoutGroupContent(element);
        break;
      default:
        throw new Error(`Unknown expression type: ${(element as any).type}`);
    }

    const totalWidth = childResult.width + this.options.padding * 2;
    
    // Position child with padding
    const childX = this.options.padding;
    const childY = this.options.padding;
    const externalBaseline = childY + childResult.baseline;
    
    // Calculate the loop path position - it should be above the child content
    const loopOffset = this.options.padding;
    const loopY = childY - loopOffset;
    
    // Calculate actual total height based on the bounds of all elements
    const minY = Math.min(loopY, childY);
    const maxY = Math.max(childY + childResult.height, childY + childResult.height);
    const totalHeight = maxY - minY + this.options.padding; // Add bottom padding
    
    const svgParts: string[] = [];

    // Add positioned child content
    svgParts.push(`<g transform="translate(${childX}, ${childY})">${childResult.svgContent}</g>`);

    // Main path through element
    const mainPath = [
      { x: 0, y: externalBaseline },
      { x: this.options.padding, y: externalBaseline },
    ];
    svgParts.push(this.createPath(mainPath));

    const exitPath = [
      { x: this.options.padding + childResult.width, y: externalBaseline },
      { x: totalWidth, y: externalBaseline },
    ];
    svgParts.push(this.createPath(exitPath));

    // Repetition loop - connect back to input above the child element
    const loopConnectionX = Math.max(this.options.padding * 0.8, 8);
    
    const loopPath = [
      { x: this.options.padding + childResult.width, y: externalBaseline },
      { x: totalWidth - this.options.padding / 2, y: externalBaseline },
      { x: totalWidth - this.options.padding / 2, y: loopY },
      { x: this.options.padding / 2, y: loopY },
      { x: this.options.padding / 2, y: externalBaseline },
      { x: loopConnectionX, y: externalBaseline },
    ];
    svgParts.push(this.createPath(loopPath));

    return {
      width: totalWidth,
      height: totalHeight,
      baseline: externalBaseline,
      svgContent: this.wrapWithDebug(svgParts.join(''), totalWidth, totalHeight, externalBaseline),
      connectorLeft: { x: 0, y: externalBaseline },
      connectorRight: { x: totalWidth, y: externalBaseline },
    };
  }

  private layoutGroupContent(expression: Expression): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return {
        width: 0,
        height: 0,
        baseline: 0,
        svgContent: '',
        connectorLeft: { x: 0, y: 0 },
        connectorRight: { x: 0, y: 0 },
      };
    }

    // Grouping is just visual, layout the first element
    const element = elements[0];
    switch (element.type) {
      case 'terminal':
        return this.layoutTerminalContent(element);
      case 'nonterminal':
        return this.layoutNonterminalContent(element);
      case 'inline':
        return this.layoutInlineContent(element);
      case 'stack':
        return this.layoutStackContent(element);
      case 'bypass':
        return this.layoutBypassContent(element);
      case 'loop':
        return this.layoutLoopContent(element);
      case 'group':
        return this.layoutGroupContent(element);
      default:
        throw new Error(`Unknown expression type: ${(element as any).type}`);
    }
  }

  // Legacy positioned methods (can be removed eventually)

  private layoutOption(expression: Expression, x: number, y: number): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return this.createEmptyLayout(x, y);
    }

    const innerResult = this.layoutExpression(elements[0], x + this.options.padding, y + this.options.padding);
    const totalWidth = innerResult.width + this.options.padding * 2;
    
    // Calculate space above and below the inner element's baseline
    const spaceAbove = innerResult.baseline - y - this.options.padding;
    const spaceBelow = y + this.options.padding + innerResult.height - innerResult.baseline;
    
    // Decide bypass position: prefer below if there's more space below, above otherwise
    const bypassBelow = spaceBelow >= spaceAbove;
    const bypassOffset = this.options.padding;
    
    // Calculate total height and external baseline
    const totalHeight = innerResult.height + this.options.padding * 2 + bypassOffset;
    const externalBaseline = innerResult.baseline; // Use inner element's baseline as external baseline
    const bypassY = bypassBelow ? 
      innerResult.baseline + bypassOffset : 
      innerResult.baseline - bypassOffset;
    
    const svgElements = [innerResult.svgContent];

    // Bypass path with proper curves
    const bypassPath = [
      { x, y: externalBaseline },
      { x: x + this.options.padding / 2, y: externalBaseline },
      { x: x + this.options.padding / 2, y: bypassY },
      { x: x + totalWidth - this.options.padding / 2, y: bypassY },
      { x: x + totalWidth - this.options.padding / 2, y: externalBaseline },
      { x: x + totalWidth, y: externalBaseline },
    ];
    svgElements.push(this.createPath(bypassPath));

    // Main path (through the element)
    const mainPath = [
      { x, y: externalBaseline },
      { x: x + this.options.padding, y: externalBaseline },
    ];
    svgElements.push(this.createPath(mainPath));

    const exitPath = [
      { x: x + this.options.padding + innerResult.width, y: externalBaseline },
      { x: x + totalWidth, y: externalBaseline },
    ];
    svgElements.push(this.createPath(exitPath));

    return {
      width: totalWidth,
      height: totalHeight,
      baseline: externalBaseline,
      svgContent: svgElements.join(''),
      connectorLeft: { x, y: externalBaseline },
      connectorRight: { x: x + totalWidth, y: externalBaseline },
    };
  }

  private layoutRepetition(expression: Expression, x: number, y: number): LayoutResult {
    const elements = expression.elements || [];
    if (elements.length === 0) {
      return this.createEmptyLayout(x, y);
    }

    const innerResult = this.layoutExpression(elements[0], x + this.options.padding, y + this.options.padding);
    const totalWidth = innerResult.width + this.options.padding * 2;
    const totalHeight = innerResult.height + this.options.padding * 3;
    
    // External baseline (for connections to this element) should be center of total height
    const externalBaseline = y + totalHeight / 2;
    // Internal baseline (for internal paths) should match the inner element
    const internalBaseline = innerResult.baseline;
    const svgElements = [innerResult.svgContent];

    // Main path through element (connect external to internal baseline)
    const mainPath = [
      { x, y: externalBaseline },
      { x: x + this.options.padding, y: internalBaseline },
    ];
    svgElements.push(this.createPath(mainPath));

    const exitPath = [
      { x: x + this.options.padding + innerResult.width, y: internalBaseline },
      { x: x + totalWidth, y: externalBaseline },
    ];
    svgElements.push(this.createPath(exitPath));

    // Repetition loop (properly aligned with internal baseline)
    const loopY = y;
    const loopPath = [
      { x: x + this.options.padding + innerResult.width, y: internalBaseline },
      { x: x + totalWidth - this.options.padding / 2, y: internalBaseline },
      { x: x + totalWidth - this.options.padding / 2, y: loopY },
      { x: x + this.options.padding / 2, y: loopY },
      { x: x + this.options.padding / 2, y: internalBaseline },
      { x: x + this.options.padding, y: internalBaseline },
    ];
    svgElements.push(this.createPath(loopPath));

    // No arrow for cleaner look

    return {
      width: totalWidth,
      height: totalHeight,
      baseline: externalBaseline,
      svgContent: svgElements.join(''),
      connectorLeft: { x, y: externalBaseline },
      connectorRight: { x: x + totalWidth, y: externalBaseline },
    };
  }

  private createEmptyLayout(x: number, y: number): LayoutResult {
    const width = 20;
    const height = 20;
    const baseline = y + height / 2;
    
    return {
      width,
      height,
      baseline,
      svgContent: '',
      connectorLeft: { x, y: baseline },
      connectorRight: { x: x + width, y: baseline },
    };
  }

  private createRoundedRect(x: number, y: number, width: number, height: number, style: any): string {
    return `<rect x="${x}" y="${y}" width="${width}" height="${height}" 
            rx="${this.options.cornerRadius}" ry="${this.options.cornerRadius}"
            fill="${style.fill}" stroke="${style.stroke}" stroke-width="${this.options.strokeWidth}"/>`;
  }

  private createText(x: number, y: number, text: string, attributes: any = {}): string {
    const attrs = Object.entries(attributes)
      .map(([key, value]) => {
        // Convert camelCase to kebab-case for SVG attributes
        const attrName = key.replace(/([A-Z])/g, '-$1').toLowerCase();
        return `${attrName}="${value}"`;
      })
      .join(' ');
    
    const attrsStr = attrs ? ` ${attrs}` : '';
    return `<text x="${x}" y="${y}" font-family="${this.options.fontFamily}" 
            font-size="${this.options.fontSize}"${attrsStr}>${this.escapeXml(text)}</text>`;
  }

  private createPath(points: Point[]): string {
    if (points.length < 2) return '';
    
    let pathData = `M ${points[0].x} ${points[0].y}`;
    
    for (let i = 1; i < points.length; i++) {
      const prev = points[i - 1];
      const current = points[i];
      
      if (i === points.length - 1) {
        // Last point, draw straight line
        pathData += ` L ${current.x} ${current.y}`;
      } else {
        const next = points[i + 1];
        
        // Use full corner radius for better quarter circles
        const cornerRadius = this.options.cornerRadius;
        
        if (prev.x === current.x) {
          // Coming from vertical direction
          const yDirection = current.y > prev.y ? 1 : -1;
          const endY = current.y - (cornerRadius * yDirection);
          pathData += ` L ${current.x} ${endY}`;
          
          if (next.x !== current.x) {
            // Turning to horizontal direction
            const xDirection = next.x > current.x ? 1 : -1;
            const endX = current.x + (cornerRadius * xDirection);
            // Create proper quarter circle using Q (quadratic curve)
            pathData += ` Q ${current.x} ${current.y} ${endX} ${current.y}`;
          }
        } else {
          // Coming from horizontal direction
          const xDirection = current.x > prev.x ? 1 : -1;
          const endX = current.x - (cornerRadius * xDirection);
          pathData += ` L ${endX} ${current.y}`;
          
          if (next.y !== current.y) {
            // Turning to vertical direction
            const yDirection = next.y > current.y ? 1 : -1;
            const endY = current.y + (cornerRadius * yDirection);
            // Create proper quarter circle using Q (quadratic curve)
            pathData += ` Q ${current.x} ${current.y} ${current.x} ${endY}`;
          }
        }
      }
    }
    
    return `<path d="${pathData}" fill="none" stroke="#333" stroke-width="${this.options.strokeWidth}"/>`;
  }

  private measureText(text: string): number {
    // Approximation: each character is roughly 0.6 * fontSize wide
    return text.length * this.options.fontSize * 0.6;
  }

  private createArrow(x: number, y: number, direction: 'left' | 'right'): string {
    const size = 6;
    const strokeWidth = 2;
    
    if (direction === 'left') {
      // Left-pointing arrow (for reverse flow)
      return `<path d="M ${x + size} ${y - size} L ${x} ${y} L ${x + size} ${y + size}" 
              fill="none" stroke="#333" stroke-width="${strokeWidth}" stroke-linecap="round" stroke-linejoin="round"/>`;
    } else {
      // Right-pointing arrow (for normal flow)
      return `<path d="M ${x - size} ${y - size} L ${x} ${y} L ${x - size} ${y + size}" 
              fill="none" stroke="#333" stroke-width="${strokeWidth}" stroke-linecap="round" stroke-linejoin="round"/>`;
    }
  }

  private escapeXml(text: string): string {
    return text
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&#39;');
  }

  /**
   * Creates debug visualization elements for bounding box and baseline
   */
  private createDebugVisualization(width: number, height: number, baseline: number, x: number = 0, y: number = 0): string {
    if (!this.options.debug) {
      return '';
    }

    const debugElements: string[] = [];
    
    // Bounding box in thin pink solid lines
    debugElements.push(
      `<rect x="${x}" y="${y}" width="${width}" height="${height}" fill="none" style="stroke: hotpink; stroke-width: 0.5px; stroke-dasharray: 2,1;"/>`
    );
    
    // Baseline in thin pink dotted line
    debugElements.push(
      `<line x1="${x}" y1="${y + baseline}" x2="${x + width}" y2="${y + baseline}" style="stroke: hotpink; stroke-width: 0.5px; stroke-dasharray: 1,1;"/>`
    );
    
    
    return debugElements.join('');
  }

  /**
   * Wraps content with debug visualization if debug mode is enabled
   */
  private wrapWithDebug(content: string, width: number, height: number, baseline: number, x: number = 0, y: number = 0): string {
    if (!this.options.debug) {
      return content;
    }
    
    return content + this.createDebugVisualization(width, height, baseline, x, y);
  }
}
