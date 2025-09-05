/**
 * Diagram configuration options
 */

export interface DiagramOptions {
  padding?: number;
  strokeWidth?: number;
  fontSize?: number;
  fontFamily?: string;
  cornerRadius?: number;
  minRailWidth?: number;
  debug?: boolean; // Enable debug visualization (bounding boxes and baselines)
  terminalStyle?: {
    fill?: string;
    stroke?: string;
    fontWeight?: string;
  };
  nonterminalStyle?: {
    fill?: string;
    stroke?: string;
    fontWeight?: string;
  };
}
