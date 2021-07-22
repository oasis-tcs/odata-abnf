# ABNF Test Tool

## Installation

You need [Node.js](https://nodejs.org/) installed and in the PATH.

In the root folder of this repository run

```sh
npm install
```

## Usage

### Command Line

In the root folder of this repository run

```sh
npm run test
```

This should result in something like

```console
JavaScript parser generated: lib/grammar.js

odata-abnf-testcases.xml
All 816 test cases passed

odata-aggregation-testcases.xml
All 91 test cases passed

odata-temporal-testcases.xml
All 7 test cases passed

Touched all 491 rules
```

The script can also watch the `abnf` directory for changes, recompile the parser if necessary, and rerun the tests:

```sh
npm run watch
```

Press `Ctrl-C` to stop the script.

## Visual Studio Code

In VS Code you can run the script in the background via **Run Task...** from the global **Terminal** menu and selecting `Check ABNF & watch`.

Press `Ctrl-C` to stop the script.
