// run parser on test cases

// const assert = require("assert");
const colors = require("colors/safe");
const fs = require("fs");
const YAML = require("yaml");

const { apgLib } = require("apg-js");
const { parser: Parser, /*ast: AST,*/ ids, utils, trace: Trace } = apgLib;
const Grammar = require("./grammar");

const config = YAML.parse(fs.readFileSync("./lib/config.yaml", "utf8"));

const parser = new Parser();
const grammar = new Grammar();

// set up parser: call back for every rule to measure rule coverage
const rulesTouched = [];
rulesTouched.length = grammar.rules.length;
grammar.rules.forEach((rule) => {
  parser.callbacks[rule.lower] = touchedCB;
});
function touchedCB(result, chars, phraseIndex, data) {
  if (result.state === ids.MATCH) {
    //TODO: use ruleIndex for accessing constraints, prepare constraints array once?
    const ruleName = grammar.rules[result.ruleIndex].name;
    const allowedMatches = data.constraints[ruleName];
    if (allowedMatches) {
      const phrase = utils.charsToString(
        chars,
        phraseIndex,
        result.phraseLength
      );
      if (!allowedMatches.includes(phrase)) {
        result.state = ids.NOMATCH;
        result.phraseLength = 0;
        if (data.mismatches)
          data.mismatches.push(`${phrase} is no ${ruleName}`);
      }
    }
    if (result.state === ids.MATCH) data.rulesTouched[result.ruleIndex] = true;
  }
}

// set up Trace
const trace = new Trace();
// don't trace boring rules
grammar.rules.forEach((rule) => {
  if (
    rule.name !== rule.name.toUpperCase() &&
    !config.trace.omit.includes(rule.name)
  )
    trace.filter.rules[rule.name] = true;
});

// // set up AST
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

function printRuleCoverage() {
  let touched = 0;
  const untouched = [];
  for (const [i, t] of rulesTouched.entries()) {
    if (t) ++touched;
    else untouched.push(grammar.rules[i].name);
  }
  if (touched == grammar.rules.length) {
    return colors.green(`Touched all ${grammar.rules.length} rules\n`);
  } else {
    return colors.yellow(
      `Touched ${touched} of ${
        grammar.rules.length
      } rules, untouched rules:\n - ${untouched.join("\n - ")}\n`
    );
  }
}

function runTestSuite(testSuite) {
  const log = [];
  let successes = 0;

  for (const tc of testSuite.TestCases) {
    if (
      parse(
        log,
        testSuite.Constraints || {},
        tc.Name,
        tc.Rule,
        tc.Input,
        tc.FailAt
        // ,tc.tokens
      )
    ) {
      successes++;
    }
  }

  if (successes === testSuite.TestCases.length) {
    log.push(
      colors.green(`All ${testSuite.TestCases.length} test cases passed`),
      ""
    );
  } else {
    process.exitCode = 1;
    const failed = testSuite.TestCases.length - successes;
    log.push(
      "",
      colors.red(`${failed} test case${failed == 1 ? "" : "s"} failed`),
      ""
    );
  }
  return log;
}

function parse(
  log,
  constraints,
  testcaseName,
  startRule,
  inputString,
  failAt
  // ,expect
) {
  const mismatches = [];
  let inputCharacterCodes;
  let result;

  if (!(typeof startRule === "string")) {
    log.push(colors.red(`${testcaseName}: invalid or missing start rule`));
    return false;
  }

  if (!(typeof inputString === "string")) {
    log.push(colors.red(`${testcaseName}: invalid or missing input string`));
    return false;
  }

  try {
    inputCharacterCodes = utils.stringToChars(inputString);
    result = parser.parse(grammar, startRule, inputCharacterCodes, {
      rulesTouched,
      constraints,
    });
  } catch (e) {
    if (e.message.match(/start rule name .* not recognized/))
      log.push(
        colors.red(`${testcaseName}: unknown start rule '${startRule}'`)
      );
    else console.log(e.message);
    return false;
  }

  if (result.success && failAt == null) {
    //TODO: construct token array from AST as an expected test result?
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
    // also output AST for partial match?
    return true;
  }

  const outcome = result.success ? "succeeds" : `fails at ${result.maxMatched}`;
  const instead =
    Number.isInteger(failAt) && result.maxMatched != failAt
      ? ` instead of ${result.success ? "failing at " : ""}${failAt}`
      : "";
  log.push(
    `${colors.red(
      `${testcaseName} ${outcome}${instead}:`
    )} ${inputString.substr(0, result.maxMatched)}${colors.yellow(
      inputString.substr(result.maxMatched)
    )}`
  );

  // rerun parser with trace on
  parser.trace = trace;
  parser.parse(grammar, startRule, inputCharacterCodes, {
    rulesTouched,
    constraints,
    mismatches,
  });
  parser.trace = null;
  // fs.writeFileSync("trace.html", trace.toHtml());
  // fs.writeFileSync("trace.json", JSON.stringify(trace.toTree(false), null, 2));
  const traceLog = [];
  collectMatches(traceLog, trace.toTree(false).tree, inputString);
  log.push(...traceLog.reverse());
  mismatches.map((m) => log.push(colors.yellow(m)));

  return false;
}

function collectMatches(log, node, inputString) {
  const text = `${".".repeat(node.depth)}${node.opData}: ${inputString.substr(
    node.phrase.index,
    node.phrase.length
  )}`;
  let hasMatch = node.state.id === ids.MATCH;

  for (let i = node.children.length - 1; i >= 0; --i) {
    const n = node.children[i];
    const has = collectMatches(log, n, inputString);
    if (has) {
      hasMatch = true;
    }
  }
  if (hasMatch) {
    if (node.state.id === ids.MATCH) log.push(colors.green(text));
    else log.push(text);
  }
  return hasMatch;
}

module.exports = { runTestSuite, printRuleCoverage };
