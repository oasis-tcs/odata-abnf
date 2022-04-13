// run parser on test cases

const assert = require("assert");
const colors = require("colors/safe");
const fs = require("fs");
const YAML = require("yaml");

const { apgLib } = require("apg-js");
const { parser: Parser, ast: AST, ids, utils, trace: Trace } = apgLib;
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
parser.callbacks.identifierleadingcharacter = function(result, chars, phraseIndex, data) {
  if (result.state === ids.NOMATCH &&
      /[\p{L}\p{Nl}_]/u.test(utils.charsToString(chars, phraseIndex, 1))) {
    result.state = ids.MATCH;
    result.phraseLength = 1;
  }
  if (result.state === ids.MATCH) data.rulesTouched[result.ruleIndex] = true;
};
parser.callbacks.identifiercharacter = function(result, chars, phraseIndex, data) {
  if (result.state === ids.NOMATCH &&
      /[\p{L}\p{Nl}\p{Nd}\p{Mn}\p{Mc}\p{Pc}\p{Cf}]/u.test(utils.charsToString(chars, phraseIndex, 1))) {
    result.state = ids.MATCH;
    result.phraseLength = 1;
  }
  if (result.state === ids.MATCH) data.rulesTouched[result.ruleIndex] = true;
};
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
        if (data.mismatches) data.mismatches.push({ phrase, ruleName });
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

  if (!testSuite.TestCases) {
    log.push(colors.yellow("No test cases found"), "");
    return log;
  }

  for (const tc of testSuite.TestCases) {
    if (
      parse(
        log,
        testSuite.Constraints || {},
        tc.Name,
        tc.Rule,
        tc.Input,
        tc.FailAt,
        tc.Expect
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
  testCaseName,
  startRule,
  inputString,
  failAt,
  expect
) {
  const mismatches = [];
  let inputCharacterCodes;
  let result;

  if (typeof startRule !== "string") {
    log.push(colors.red(`${testCaseName}: invalid or missing start rule`));
    return false;
  }

  if (typeof inputString !== "string") {
    log.push(colors.red(`${testCaseName}: invalid or missing input string`));
    return false;
  }

  try {
    setupAST(log, testCaseName, expect);

    inputCharacterCodes = utils.stringToChars(inputString);
    result = parser.parse(grammar, startRule, inputCharacterCodes, {
      rulesTouched,
      constraints,
    });
  } catch (e) {
    if (e.message.match(/start rule name .* not recognized/))
      log.push(
        colors.red(`${testCaseName}: unknown start rule '${startRule}'`)
      );
    else if (e.message.match(/ast.js: init:/)) {
      const m = e.message.match(/ast.js: init: node '(?<ruleName>[^']*)/);
      log.push(
        colors.red(
          `${testCaseName}: unknown Expect token rule '${m.groups.ruleName}'`
        )
      );
    } else console.log(e.message);

    return false;
  }

  if (result.success && failAt == null) {
    return checkTokens(log, testCaseName, expect);
  }

  if (!result.success && result.maxMatched == failAt) {
    //TODO: also check tokens for partial match?
    return true;
  }

  const outcome = result.success ? "succeeds" : `fails at ${result.maxMatched}`;
  const position = result.success ? `failing at ${failAt}` : `${failAt}`;
  const instead =
    Number.isInteger(failAt) && result.maxMatched != failAt
      ? ` instead of ${position}`
      : "";
  const message = `${testCaseName} ${outcome}${instead}:`;
  const matchedInput = inputString.substring(0, result.maxMatched);
  const remainingInput = inputString.substring(result.maxMatched);
  log.push(
    `${colors.red(message)} ${matchedInput}${colors.yellow(remainingInput)}`
  );

  // rerun parser with trace on
  parser.trace = trace;
  parser.parse(grammar, startRule, inputCharacterCodes, {
    rulesTouched,
    constraints,
    mismatches,
  });
  parser.trace = null;
  //x fs.writeFileSync("trace.html", trace.toHtml());
  //x fs.writeFileSync("trace.json", JSON.stringify(trace.toTree(false), null, 2));
  const traceLog = [];
  collectMatches(traceLog, trace.toTree(false).tree, inputString);
  log.push(...traceLog.reverse());
  mismatches.map((m) =>
    log.push(
      matchedInput.endsWith(m.phrase)
        ? colors.yellow(`${m.phrase} is no ${m.ruleName}`)
        : `${m.phrase} is no ${m.ruleName}`
    )
  );

  return false;
}

function setupAST(log, testCaseName, expect) {
  if (!expect) {
    parser.ast = undefined;
    return;
  }

  parser.ast = new AST();

  for (const token of expect) {
    const ruleName = token.substring(0, token.indexOf(":"));
    parser.ast.callbacks[ruleName] = matchTokenCB(ruleName);
  }
}

// helper for AST callbacks, see https://github.com/ldthomas/apg-js2-examples/blob/61a36fd963ba544c0630a533c053f60d18d878d2/ast/setup.js#L29-L74
function matchTokenCB(ruleName) {
  return (state, chars, phraseIndex, phraseLength, data) => {
    if (state === ids.SEM_PRE)
      data.push(
        `${ruleName}:${utils.charsToString(chars, phraseIndex, phraseLength)}`
      );
    return ids.SEM_SKIP;
  };
}

function checkTokens(log, testCaseName, expect) {
  if (expect) {
    // construct token array from AST as an expected test result
    const data = [];
    parser.ast.translate(data);
    try {
      assert.deepStrictEqual(data, expect);
    } catch (e) {
      log.push(
        e.message.replace(
          /^Expected values to be strictly deep-equal:/,
          colors.red(`${testCaseName} parses into unexpected tokens:`)
        )
      );
      return false;
    }
  }
  return true;
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
