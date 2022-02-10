const assert = require("assert");
const colors = require("colors/safe");
const { runTestSuite, printRuleCoverage } = require("../lib/runTests");
const Grammar = require("../lib/grammar");

it("grammar.toString - just to get full coverage", () => {
  const grammar = new Grammar();
  const text = grammar.toString();
  assert.notStrictEqual(text.length, 0);
});

describe("run test suite", () => {
  it("no test cases", () => {
    const suite = {};
    assert.deepStrictEqual(runTestSuite(suite), [
      colors.yellow("No test cases found"),
      "",
    ]);
    assert.strictEqual(undefined, process.exitCode, "process exit code");

    const coverage = printRuleCoverage().split("\n");
    assert.match(coverage[0], /Touched 0 of \d+ rules, untouched rules:/);
    assert.strictEqual(coverage[1], colors.yellow(" - odataUri"));
  });

  it("empty test case list", () => {
    const suite = { TestCases: [] };
    assert.deepStrictEqual(runTestSuite(suite), [
      colors.green("All 0 test cases passed"),
      "",
    ]);
    assert.strictEqual(undefined, process.exitCode, "process exit code");

    const coverage = printRuleCoverage().split("\n");
    assert.match(coverage[0], /Touched 0 of \d+ rules, untouched rules:/);
    assert.strictEqual(coverage[1], colors.yellow(" - odataUri"));
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
        {
          Name: "empty input",
          Input: "",
          Rule: "odataRelativeUri",
          FailAt: 0,
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [colors.green("All 3 test cases passed"), ""],
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
        {
          Name: "fail to fail",
          Input: "MyEntitySet",
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
        colors.green("odataRelativeUri: MyEntity"),
        colors.green(".resourcePath: MyEntity"),
        colors.green("..entitySetName: MyEntity"),

        colors.red("fail at wrong position fails at 8 instead of 7:") +
          " MyEntity" +
          colors.yellow("-Set"),
        colors.green("odataRelativeUri: MyEntity"),
        colors.green(".resourcePath: MyEntity"),
        colors.green("..entitySetName: MyEntity"),

        colors.red("fail to fail succeeds instead of failing at 7:") +
          " MyEntitySet",
        colors.green("odataRelativeUri: MyEntitySet"),
        colors.green(".resourcePath: MyEntitySet"),
        colors.green("..entitySetName: MyEntitySet"),

        "",
        colors.red("3 test cases failed"),
        "",
      ],
      "run result"
    );
    assert.strictEqual(1, process.exitCode, "process exit code");
  });

  it("test suite with constraints", () => {
    const suite = {
      Constraints: {
        entitySetName: ["MyEntitySet"],
        singletonEntity: [],
        actionImport: [],
      },
      TestCases: [
        { Name: "success", Input: "MyEntitySet/1", Rule: "odataRelativeUri" },
        {
          Name: "fail due to constraint",
          Input: "notMyEntitySet/1",
          Rule: "odataRelativeUri",
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [
        colors.red("fail due to constraint fails at 14:") +
          " notMyEntitySet" +
          colors.yellow("/1"),
        colors.green("odataRelativeUri: notMyEntitySet"),
        colors.green(".resourcePath: notMyEntitySet"),
        "..entityColFunctionImportCall: ",
        colors.green("...entityColFunctionImport: notMyEntitySet"),
        "..entityFunctionImportCall: ",
        colors.green("...entityFunctionImport: notMyEntitySet"),
        "..complexColFunctionImportCall: ",
        colors.green("...complexColFunctionImport: notMyEntitySet"),
        "..complexFunctionImportCall: ",
        colors.green("...complexFunctionImport: notMyEntitySet"),
        "..primitiveColFunctionImportCall: ",
        colors.green("...primitiveColFunctionImport: notMyEntitySet"),
        "..primitiveFunctionImportCall: ",
        colors.green("...primitiveFunctionImport: notMyEntitySet"),
        colors.green("..functionImportCallNoParens: notMyEntitySet"),
        colors.green("...entityFunctionImport: notMyEntitySet"),
        colors.yellow("notMyEntitySet is no entitySetName"),
        colors.yellow("notMyEntitySet is no singletonEntity"),
        colors.yellow("notMyEntitySet is no actionImport"),
        "",
        colors.red("1 test case failed"),
        "",
      ],
      "run result"
    );
  });

  it("test case with correct expectation", () => {
    const suite = {
      TestCases: [
        {
          Name: "correct expectation",
          Input: "MyEntitySet(1)/MyProperty",
          Rule: "odataRelativeUri",
          Expect: [
            "entitySetName:MyEntitySet",
            "keyPredicate:(1)",
            "entityColNavigationProperty:MyProperty",
          ],
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [colors.green("All 1 test cases passed"), ""],
      "run result"
    );
  });

  it("test case with wrong expectation", () => {
    const suite = {
      TestCases: [
        {
          Name: "wrong expectation",
          Input: "MyEntitySet(1)/MyProperty",
          Rule: "odataRelativeUri",
          Expect: [
            "entitySetName:MyEntitySet",
            "keyPredicate:(1)",
            "primitiveProperty:MyProperty",
          ],
        },
      ],
    };
    const log = runTestSuite(suite);
    assert.equal(log[2], colors.red("1 test case failed"), "run result");
    assert.deepStrictEqual(
      // eslint-disable-next-line no-control-regex
      log[0].replace(/\u001b\[\d+m/g, "").split("\n"),
      [
        "wrong expectation parses into unexpected tokens:",
        "+ actual - expected",
        "",
        "  [",
        "    'entitySetName:MyEntitySet',",
        "    'keyPredicate:(1)',",
        "-   'primitiveProperty:MyProperty'",
        "  ]",
      ],
      "tokens"
    );
  });

  it("test case with wrong rule name in expectation", () => {
    const suite = {
      TestCases: [
        {
          Name: "wrong expectation",
          Input: "MyEntitySet(1)/MyProperty",
          Rule: "odataRelativeUri",
          Expect: ["no-rule:foo"],
        },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [
        colors.red("wrong expectation: unknown Expect token rule 'no-rule'"),
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
        {},
        { Name: "no rule" },
        { Name: "no input", Rule: "foo" },
        { Name: "non-existing rule", Rule: "not there", Input: "MyEntitySet" },
      ],
    };
    assert.deepStrictEqual(
      runTestSuite(suite),
      [
        colors.red("undefined: invalid or missing start rule"),
        colors.red("no rule: invalid or missing start rule"),
        colors.red("no input: invalid or missing input string"),
        colors.red("non-existing rule: unknown start rule 'not there'"),
        "",
        colors.red("4 test cases failed"),
        "",
      ],
      "run result"
    );
  });
});
