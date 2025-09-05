/**
 * Path generation utilities for connection-point-centric rendering
 */

import { Point } from '../types/common.js';

export class PathBuilder {
  private strokeWidth: number;
  private cornerRadius: number;

  constructor(strokeWidth: number = 5, cornerRadius: number = 12) {
    this.strokeWidth = strokeWidth;
    this.cornerRadius = cornerRadius;
  }

  /**
   * Creates a straight horizontal line from connection point to connection point
   * Used for: terminal, nonterminal, group
   */
  public createHorizontalPath(fromX: number, toX: number, y: number): string {
    return `<path d="M ${fromX} ${y} L ${toX} ${y}" fill="none" stroke="#333" stroke-width="${this.strokeWidth}"/>`;
  }

  /**
   * Creates a rectilinear path from parent connection point to child connection point
   * Used for: stack, bypass connections
   */
  public createRectilinearPath(from: Point, to: Point): string {
    if (from.y === to.y) {
      // Same height - straight line
      return `<path d="M ${from.x} ${from.y} L ${to.x} ${to.y}" fill="none" stroke="#333" stroke-width="${this.strokeWidth}"/>`;
    }

    // Check if we need bending or can go straight
    const verticalDistance = Math.abs(to.y - from.y);
    
    if (verticalDistance < this.cornerRadius) {
      // Too close for proper bending - just do straight line
      return `<path d="M ${from.x} ${from.y} L ${to.x} ${to.y}" fill="none" stroke="#333" stroke-width="${this.strokeWidth}"/>`;
    }

    // Create proper rectilinear path with corners
    const midX = (from.x + to.x) / 2;
    
    return `<path d="M ${from.x} ${from.y} L ${midX - this.cornerRadius} ${from.y} Q ${midX} ${from.y} ${midX} ${from.y + (to.y > from.y ? this.cornerRadius : -this.cornerRadius)} L ${midX} ${to.y + (to.y > from.y ? -this.cornerRadius : this.cornerRadius)} Q ${midX} ${to.y} ${midX + this.cornerRadius} ${to.y} L ${to.x} ${to.y}" fill="none" stroke="#333" stroke-width="${this.strokeWidth}"/>`;
  }

  /**
   * Creates a bypass path that goes around a child element
   * Used for: bypass element
   */
  public createBypassPath(leftConnection: Point, rightConnection: Point, childBaseline: number, isAbove: boolean): string {
    const bypassY = childBaseline + (isAbove ? -this.cornerRadius * 2 : this.cornerRadius * 2);
    const padding = this.cornerRadius;

    return `<path d="M ${leftConnection.x} ${leftConnection.y} L ${leftConnection.x + padding} ${leftConnection.y} Q ${leftConnection.x + padding + this.cornerRadius} ${leftConnection.y} ${leftConnection.x + padding + this.cornerRadius} ${bypassY} L ${rightConnection.x - padding - this.cornerRadius} ${bypassY} Q ${rightConnection.x - padding} ${bypassY} ${rightConnection.x - padding} ${rightConnection.y} L ${rightConnection.x} ${rightConnection.y}" fill="none" stroke="#333" stroke-width="${this.strokeWidth}"/>`;
  }

  /**
   * Creates a loop path that connects back to the start
   * Used for: loop element
   */
  public createLoopPath(leftConnection: Point, rightConnection: Point, childBaseline: number, isAbove: boolean): string {
    const loopY = childBaseline + (isAbove ? -this.cornerRadius * 3 : this.cornerRadius * 3);
    const padding = this.cornerRadius;

    return `<path d="M ${rightConnection.x} ${rightConnection.y} L ${rightConnection.x + padding} ${rightConnection.y} Q ${rightConnection.x + padding + this.cornerRadius} ${rightConnection.y} ${rightConnection.x + padding + this.cornerRadius} ${loopY} L ${leftConnection.x - padding - this.cornerRadius} ${loopY} Q ${leftConnection.x - padding} ${loopY} ${leftConnection.x - padding} ${leftConnection.y} L ${leftConnection.x} ${leftConnection.y}" fill="none" stroke="#333" stroke-width="${this.strokeWidth}"/>`;
  }

  /**
   * Creates connection paths for stack layout - from parent to each child
   */
  public createStackConnections(parentLeft: Point, parentRight: Point, childConnections: { left: Point, right: Point }[]): string[] {
    const paths: string[] = [];
    
    for (const child of childConnections) {
      // Left connection: parent left to child left
      paths.push(this.createRectilinearPath(parentLeft, child.left));
      
      // Right connection: child right to parent right  
      paths.push(this.createRectilinearPath(child.right, parentRight));
    }
    
    return paths;
  }

  /**
   * Validates that child is properly positioned relative to parent connection point
   */
  public isValidChildPosition(parentY: number, childY: number): boolean {
    const distance = Math.abs(childY - parentY);
    return distance === 0 || distance >= this.cornerRadius;
  }
}
