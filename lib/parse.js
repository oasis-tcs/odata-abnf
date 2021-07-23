// run parser on test cases

const assert = require("assert");
const colors = require("colors/safe");
const fs = require("fs");
const { readXml } = require("./convertTestcases");
// const YAML = require("yaml");
const { apgLib } = require("apg-js");
const { parser: Parser, ast: AST, ids, utils, trace: Trace } = apgLib;
const Grammar = require("./grammar");

const parser = new Parser();
const grammar = new Grammar();

// set up parser: call back for every rule to measure rule coverage
const rulesTouched = [];
rulesTouched.length = grammar.rules.length;
grammar.rules.forEach((rule) => {
  parser.callbacks[rule.lower] = touchedCB;
});
var currentConstraints = {};
function touchedCB(result, chars, phraseIndex, data) {
  if (result.state === ids.MATCH) {
    const ruleName = grammar.rules[result.ruleIndex].name;
    const allowedMatches = currentConstraints[ruleName];
    if (allowedMatches) {
      const phrase = utils.charsToString(
        chars,
        phraseIndex,
        result.phraseLength
      );
      if (!allowedMatches.includes(phrase)) {
        result.state = ids.NOMATCH;
        result.phraseLength = 0;
        //TODO: do we need this? if yes, how to integrate into trace output?
        // data.mismatches.push(`${phrase} is no ${ruleName}`);
      }
    }
    if (result.state === ids.MATCH) data.rulesTouched[result.ruleIndex] = true;
  }
}

// set up Trace
const NOTRACE = [
  "A-to-F",
  "day",
  "hour",
  "identifierLeadingCharacter",
  "identifierCharacter",
  "minute",
  "month",
  "odataIdentifier",
  "oneToNine",
  "second",
  "year",
  "zeroToFiftyNine",
];
const trace = new Trace();
// don't trace boring rules
grammar.rules.forEach((rule) => {
  if (rule.name !== rule.name.toUpperCase() && !NOTRACE.includes(rule.name))
    trace.filter.rules[rule.name] = true;
});

// // set up AST
// const config = YAML.parse(fs.readFileSync("./config.yaml", "utf8"));
// const ast = new AST();
// parser.ast = ast;
// // define AST callbacks, see https://github.com/ldthomas/apg-js2-examples/blob/61a36fd963ba544c0630a533c053f60d18d878d2/ast/setup.js#L29-L74
// config.rulenameTokens.forEach(
//   (ruleName) => (ast.callbacks[ruleName] = rulenameTokenCB(ruleName))
// );
// config.matchTokens.forEach(
//   (ruleName) => (ast.callbacks[ruleName] = matchTokenCB)
// );
//
// function rulenameTokenCB(rulename) {
//   return (state, chars, phraseIndex, phraseLength, data) => {
//     if (state === ids.SEM_PRE) data.push(rulename);
//     return ids.SEM_OK;
//   };
// }
//
// function matchTokenCB(state, chars, phraseIndex, phraseLength, data) {
//   if (state === ids.SEM_PRE)
//     data.push(utils.charsToString(chars, phraseIndex, phraseLength));
//   return ids.SEM_SKIP;
// }

const abnfFolder = "./abnf/";

fs.readdirSync(abnfFolder)
  //TODO: switch to *.yaml and use YAML.parse(...)
  .filter((fn) => fn.endsWith(".xml"))
  .forEach((xmlfile) => {
    console.log(`${xmlfile}`);
    const testSuite = readXml(fs.readFileSync(abnfFolder + xmlfile, "utf8"));
    currentConstraints = testSuite.Constraints || {};
    runTestSuite(testSuite);
  });

let touched = 0;
const untouched = [];
for (const [i, t] of rulesTouched.entries()) {
  if (t) ++touched;
  else untouched.push(grammar.rules[i].name);
}
if (touched == grammar.rules.length) {
  console.log(colors.green(`Touched all ${grammar.rules.length} rules\n`));
} else {
  console.log(
    colors.yellow(
      `Touched ${touched} of ${
        grammar.rules.length
      } rules, untouched rules:\n - ${untouched.join("\n - ")}\n`
    )
  );
}

function runTestSuite(testSuite) {
  let successes = 0;

  for (const tc of testSuite.TestCases) {
    //TODO: rename fields to align with RSDL ABNF test cases?
    if (parse(tc.Name, tc.Rule, tc.Input, tc.FailAt /*, tc.tokens*/))
      successes++;
  }

  if (successes === testSuite.TestCases.length) {
    console.log(
      colors.green(`All ${testSuite.TestCases.length} test cases passed\n`)
    );
  } else {
    const failed = testSuite.TestCases.length - successes;
    console.log(
      colors.red(`\n${failed} test case${failed == 1 ? "" : "s"} failed\n`)
    );
    process.exitCode = 1;
  }
}

function parse(testcaseName, startRule, inputString, failAt, expect) {
  const mismatches = [];
  inputCharacterCodes = utils.stringToChars(inputString);

  const result = parser.parse(grammar, startRule, inputCharacterCodes, {
    rulesTouched,
    mismatches,
  });

  if (result.success && failAt == null) {
    //TODO: construct token array from AST as an expected test result
    // if (expect) {
    //   const data = [];
    //   ast.translate(data);
    //   try {
    //     assert.deepStrictEqual(data, expect);
    //   } catch (e) {
    //     console.log(
    //       e.message.replace(
    //         /^Expected values to be strictly deep-equal/,
    //         colors.red("Unexpected tokens")
    //       )
    //     );
    //     return false;
    //   }
    // }
    return true;
  }

  if (!result.success && result.maxMatched == failAt) {
    return true;
  }

  const instead =
    Number.isInteger(failAt) && result.maxMatched != failAt
      ? ` instead of ${failAt}`
      : "";
  console.log(
    `${colors.red(
      `${testcaseName} fails at ${result.maxMatched}${instead}:`
    )} ${inputString.substr(0, result.maxMatched)}${colors.yellow(
      inputString.substr(result.maxMatched)
    )}`
  );

  // rerun parser with trace on
  parser.trace = trace;
  parser.parse(grammar, startRule, inputCharacterCodes, {
    rulesTouched,
    mismatches: [],
  });
  parser.trace = null;
  //TODO: do we need this?
  // console.dir(mismatches);
  // fs.writeFileSync("trace.html", trace.toHtml());
  // fs.writeFileSync("trace.json", JSON.stringify(trace.toTree(false), null, 2));
  printNode(trace.toTree(false).tree, inputString);

  return false;
}

function printNode(node, inputString) {
  // console.dir(node);
  //TODO: indent (with dots?) to depth, print opData and substring from phrase.index with phrase.length
  //TODO: recurse over matching children state.name == "MATCH" (or state.id == ids.MATCH)
  console.log(
    `${".".repeat(node.depth)}${node.opData}: ${inputString.substr(
      node.phrase.index,
      node.phrase.length
    )}`
  );
  node.children
    .filter((n) => n.state.id === ids.MATCH)
    .forEach((n) => {
      printNode(n, inputString);
    });
}
