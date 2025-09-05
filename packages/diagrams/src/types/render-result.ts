/**
 * Connection-point-centric rendering types for unified path rendering
 */

import { Point } from './common.js';

export class RenderResult {
  constructor(
    public readonly width: number,
    public readonly height: number,
    public readonly baseline: number,
    public readonly svgContent: string
  ) {}

  /**
   * Get the left connection point (always at x=0, y=baseline)
   */
  get leftConnection(): Point {
    return { x: 0, y: this.baseline };
  }

  /**
   * Get the right connection point (always at x=width, y=baseline)
   */
  get rightConnection(): Point {
    return { x: this.width, y: this.baseline };
  }

  /**
   * Get both connection points
   */
  getConnectionPoints(): { left: Point; right: Point } {
    return {
      left: this.leftConnection,
      right: this.rightConnection
    };
  }
}
