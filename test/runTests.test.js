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
    assert.deepStrictEqual(runTestSuite(suite), [
      colors.green("All 0 test cases passed"),
      "",
    ]);

    const coverage = printRuleCoverage().split("\n");
    assert.match(coverage[0], /Touched 0 of [0-9]+ rules, untouched rules:/);
    assert.strictEqual(coverage[1], colors.yellow(" - dummyStartRule"));
  });

  it("successful test suite", () => {
    const suite = {
      TestCases: [
        { Name: "success", Input: "MyEntitySet", Rule: "odataRelativeUri" },
        {
          Name: "failAt",
          Input: "MyEntity-Set",
          Rule: "odataRelativeUri",
          FailAt: 8,
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [colors.green("All 2 test cases passed"), ""],
      "run result"
    );
  });

  it("failing tests", () => {
    const suite = {
      TestCases: [
        {
          Name: "fail instead of succeed",
          Input: "MyEntity-Set",
          Rule: "odataRelativeUri",
        },
        {
          Name: "fail at wrong position",
          Input: "MyEntity-Set",
          Rule: "odataRelativeUri",
          FailAt: 7,
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [
        colors.red("fail instead of succeed fails at 8:") +
          " MyEntity" +
          colors.yellow("-Set"),
        "odataRelativeUri: MyEntity",
        ".resourcePath: MyEntity",
        "..entitySetName: MyEntity",

        colors.red("fail at wrong position fails at 8 instead of 7:") +
          " MyEntity" +
          colors.yellow("-Set"),
        "odataRelativeUri: MyEntity",
        ".resourcePath: MyEntity",
        "..entitySetName: MyEntity",

        "",
        colors.red("2 test cases failed"),
        "",
      ],
      "run result"
    );
  });

  it("test suite with constraints", () => {
    const suite = {
      Constraints: { resourcePath: ["MyEntitySet"] },
      TestCases: [
        { Name: "success", Input: "MyEntitySet", Rule: "odataRelativeUri" },
        {
          Name: "fail due to constraint",
          Input: "notMyEntitySet",
          Rule: "odataRelativeUri",
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [
        colors.red("fail due to constraint fails at 14:") + " notMyEntitySet",
        "odataRelativeUri: ",
        colors.yellow("notMyEntitySet is no resourcePath"),

        "",
        colors.red("1 test case failed"),
        "",
      ],
      "run result"
    );
  });

  it("invalid test cases", () => {
    const suite = {
      TestCases: [
        { Name: "non-existing rule", Input: "MyEntitySet", Rule: "not there" },
        {},
      ],
    };
    // assert.deepStrictEqual(
    //   runTestSuite(suite),
    //   [
    //     //TODO
    //   ],
    //   "run result"
    // );
  });
});
