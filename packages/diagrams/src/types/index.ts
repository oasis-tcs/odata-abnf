/**
 * Type definitions for Railroad.js
 * Re-exports all types from organized files
 */

// Common types
export * from './common.js';

// Core grammar types
export * from './grammar.js';

// Diagram configuration
export * from './diagram-options.js';

// Layout result types (current SVG engine)
export { LayoutResult } from './layout-result.js';

// New render result types (connection-point-centric)
export { RenderResult } from './render-result.js';
