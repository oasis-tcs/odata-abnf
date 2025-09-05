/**
 * Railroad diagram generator class
 */

import * as fs from 'fs';
import * as path from 'path';
import { Writable } from 'stream';
import { GrammarParser } from './grammar-parser';
import { HTMLGenerator } from './html-generator';
import { DiagramOptions, GrammarRule } from '../types';

export class RailroadGenerator {
  private options: DiagramOptions;
  private htmlGenerator: HTMLGenerator;

  constructor(options: Partial<DiagramOptions> = {}) {
    this.options = {
      ...options,
    };
    
    this.htmlGenerator = new HTMLGenerator(this.options);
  }

  /**
   * Core generate method - takes parsed rules and writes to stream
   * All other generate methods build on this one
   */
  public generate(rules: GrammarRule[], outputStream: Writable, filename?: string): void {
    console.log(`Generating railroad diagrams for ${rules.length} rules`);
    
    const html = this.htmlGenerator.generateHTML(rules, filename);
    outputStream.write(html);
    
    if (outputStream !== process.stdout) {
      outputStream.end();
    }
    
    console.log('Railroad diagram generation completed');
  }

  /**
   * Generate from grammar text content and write to stream
   */
  public generateFromContent(grammarText: string, outputStream: Writable, filename?: string): void {
    console.log('Parsing grammar content');
    
    const parser = new GrammarParser(grammarText);
    const rules = parser.parseGrammar();
    
    console.log(`Parsed ${rules.length} grammar rules`);
    
    this.generate(rules, outputStream, filename);
  }

  /**
   * Generate from file path and write to stream
   */
  public generateFromFile(inputPath: string, outputStream: Writable): void {
    console.log(`Reading grammar from file: ${inputPath}`);
    
    if (!fs.existsSync(inputPath)) {
      throw new Error(`Grammar file not found: ${inputPath}`);
    }
    
    const grammarText = fs.readFileSync(inputPath, 'utf-8');
    const filename = path.basename(inputPath);
    this.generateFromContent(grammarText, outputStream, filename);
  }

  /**
   * Generate from grammar content and return as string
   */
  public generateToString(grammarText: string, filename?: string): string {
    const parser = new GrammarParser(grammarText);
    const rules = parser.parseGrammar();
    return this.htmlGenerator.generateHTML(rules, filename);
  }

  /**
   * Generate from file and write to another file
   */
  public generateToFile(inputPath: string, outputPath?: string): void {
    if (!outputPath) {
      const inputDir = path.dirname(inputPath);
      const inputName = path.basename(inputPath, path.extname(inputPath));
      outputPath = path.join(inputDir, `${inputName}.html`);
    }
    
    console.log(`Generating ${inputPath} -> ${outputPath}`);
    
    const outputStream = fs.createWriteStream(outputPath);
    this.generateFromFile(inputPath, outputStream);
    
    console.log(`Railroad diagram saved to: ${outputPath}`);
  }

  /**
   * Generate from grammar content and write to file
   */
  public generateFromContentToFile(grammarText: string, outputPath: string, filename?: string): void {
    console.log(`Generating grammar content -> ${outputPath}`);
    
    const outputStream = fs.createWriteStream(outputPath);
    this.generateFromContent(grammarText, outputStream, filename);
    
    console.log(`Railroad diagram saved to: ${outputPath}`);
  }

  /**
   * Set generation options
   */
  public setOptions(options: Partial<DiagramOptions>): void {
    this.options = { ...this.options, ...options };
    this.htmlGenerator = new HTMLGenerator(this.options);
  }
}
