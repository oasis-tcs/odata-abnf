const assert = require("assert");
const colors = require("colors/safe");
const { runTestSuite, printRuleCoverage } = require("../lib/runTests");
const Grammar = require("../lib/grammar");

// const grammar = new Grammar();

it("grammar.toString - just to get full coverage", () => {
  const grammar = new Grammar();
  const text = grammar.toString();
  assert.notStrictEqual(text.length, 0);
});

describe("run test suite", () => {
  before;
  it("empty test suite", () => {
    const suite = { TestCases: [] };
    const result = runTestSuite(suite);
    assert.strictEqual(result, colors.green("All 0 test cases passed\n"));

    const coverage = printRuleCoverage().split("\n");
    assert.match(coverage[0], /Touched 0 of [0-9]+ rules, untouched rules:/);
    assert.strictEqual(coverage[1], colors.yellow(" - dummyStartRule"));
  });

  it("typical test suite", () => {
    const suite = {
      TestCases: [
        //TODO:
        //- success
        //- failAt expected position
        //- fail
        //- failAt wrong position
        //- fail due to mismatch
      ],
    };
    const result = runTestSuite(suite);
  });
});
