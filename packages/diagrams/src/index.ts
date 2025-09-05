#!/usr/bin/env node

/**
 * Railroad.js - A TypeScript tool for generating railroad diagrams from ABNF grammar files.
 */

import { RailroadGenerator } from './render/railroad-generator';
import { parseAbnfToRailroad } from './abnf/index.js';
import * as fs from 'fs';
import * as path from 'path';

function main(): void {
  // Use minimist for argument parsing
  const minimist = require('minimist');
  const argv = minimist(process.argv.slice(2));
  const allowedOptions = new Set(['debug', 'no-debug', 'ast-tree', '_']);

  // Warn for unexpected options
  Object.keys(argv).forEach(opt => {
    if (!allowedOptions.has(opt)) {
      console.warn(`Warning: Unexpected command line option: --${opt}`);
    }
  });

  // Input file is first positional argument
  const inputFile = argv._[0];
  if (!inputFile) {
    console.error('Railroad.js - Railroad Diagram Generator');
    console.error('Usage: railroad-js <input-file> [--debug] [--no-debug] [--railroad]');
    console.error('');
    console.error('Options:');
    console.error('  --debug     Show debug information (bounding boxes and baselines)');
    console.error('  --no-debug  Explicitly disable debug mode');
    console.error('  --railroad  Also generate .railroad file');
    process.exit(1);
  }

  // Handle debug flag precedence: --no-debug overrides --debug
  const debugMode = argv['debug'] && !argv['no-debug'];
  const options = {
    debug: debugMode
  };
  if (debugMode) {
    console.log('Debug mode enabled - showing bounding boxes and baselines');
  } else if (argv['no-debug']) {
    console.log('Debug mode explicitly disabled');
  }
  
  // // Only accept .abnf files
  // const ext = require('path').extname(inputFile).toLowerCase();
  // if (ext !== '.abnf') {
  //   console.error('Error: Only .abnf files are accepted as input.');
  //   process.exit(1);
  // }

  // Check for --ast-tree option
  const printAstTree = argv['ast-tree'] === true;

  try {
    generateFromAbnf(inputFile, options, printAstTree);
  } catch (error) {
    console.error('Error generating railroad diagram:', error);
    process.exit(1);
  }
}

function generateFromAbnf(inputFile: string, options: { debug: boolean }, printAstTree: boolean): void {
  // Read ABNF file
  const abnfContent = fs.readFileSync(inputFile, 'utf-8');

  // Parse ABNF to AST
  const { parseAbnf, RailroadTransformer } = require('./abnf/index.js');
  const ast = parseAbnf(abnfContent, inputFile);

  // Transform AST to railroad rules directly
  const railroadRules = RailroadTransformer.transformRuleList(ast);

  if (printAstTree) {
    printAsciiAstTree(ast);
    return;
  }

  // Always generate HTML diagram
  const generator = new RailroadGenerator(options);
  const htmlFile = inputFile.replace(/\.[^.]*$/, '.html');
  const outputStream = fs.createWriteStream(htmlFile);
  generator.generate(railroadRules, outputStream, path.basename(inputFile));
  console.log(`HTML file saved to: ${htmlFile}`);
}

function printAsciiAstTree(ast: any): void {
  function printNode(node: any, indent: string = '', isLast: boolean = true) {
    const marker = isLast ? '└─' : '├─';
    let label = '';
    if (node.type) {
      label += node.type;
      if (node.name) label += ` (${node.name})`;
      if (node.value) label += `: "${node.value}"`;
    } else if (node.kind) {
      label += node.kind;
      if (node.name) label += ` (${node.name})`;
      if (node.value) label += `: "${node.value}"`;
    }
    console.log(indent + marker + label);
    if (node.elements && Array.isArray(node.elements)) {
      for (let i = 0; i < node.elements.length; i++) {
        printNode(node.elements[i], indent + (isLast ? '   ' : '│  '), i === node.elements.length - 1);
      }
    }
    if (node.expression) {
      printNode(node.expression, indent + (isLast ? '   ' : '│  '), true);
    }
    if (node.rules && Array.isArray(node.rules)) {
      for (let i = 0; i < node.rules.length; i++) {
        printNode(node.rules[i], indent + (isLast ? '   ' : '│  '), i === node.rules.length - 1);
      }
    }
  }
  if (ast.rules && Array.isArray(ast.rules)) {
    console.log('AST Tree:');
    for (let i = 0; i < ast.rules.length; i++) {
      printNode(ast.rules[i], '', i === ast.rules.length - 1);
    }
  } else {
    printNode(ast);
  }
}

if (require.main === module) {
  main();
}

export { RailroadGenerator };
