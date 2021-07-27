const assert = require("assert");
const { readXml, json2yaml } = require("../lib/convertTestsuite");

describe("convert XML test suite to JSON", () => {
  it("read empty test suite", () => {
    assert.deepStrictEqual(
      readXml(""),
      { Constraints: {}, TestCases: [] },
      "test suite as JSON"
    );
  });

  it("read typical test suite", () => {
    assert.deepStrictEqual(
      readXml(
        `<!--

           header comment 

         -->    
         <TestSuite attributesAreIgnored="true">
           <Constraint Rule="foo">
             <Match>Foo1</Match>
             <Match>Foo2</Match>
           </Constraint>
           <Constraint Rule="bar">
             <Match>Bar1</Match>
           </Constraint>
           <Constraint Rule="foo">
             <Match>Foo3</Match>
           </Constraint>
           <Constraint Rule="bar">
           </Constraint>
           <Constraint Rule="baz">
           </Constraint>

           <TestCase Name="first test case" Rule="first-rule">
             <Input>first input</Input>
           </TestCase>
           <!-- more to test -->
           <TestCase Name="second test case" Rule="second-rule" FailAt="42">
             <Input>second input</Input>
           </TestCase>
           <TestCase Name="third test case" Rule="first-rule" allOtherAttributesAreIgnored="true">
             <Input>third input</Input>
           </TestCase>
          </TestSuite>`
      ),
      {
        //TODO: $comment: " header comment"
        Constraints: { foo: ["Foo1", "Foo2", "Foo3"], bar: ["Bar1"], baz: [] },
        TestCases: [
          {
            Name: "first test case",
            Rule: "first-rule",
            Input: "first input",
          },
          {
            Name: "second test case",
            Rule: "second-rule",
            Input: "second input",
            FailAt: 42,
          },
          {
            Name: "third test case",
            Rule: "first-rule",
            Input: "third input",
          },
        ],
      },
      "test suite aa JSON"
    );
  });
});

describe("convert JSON test suite to YAML", () => {
  it("convert empty test suite", () => {
    assert.deepStrictEqual(
      json2yaml({ Constraints: {}, TestCases: [] }),
      "TestCases: []\n",
      "test suite as JSON"
    );
  });

  it("convert test suite without constraints", () => {
    assert.deepStrictEqual(
      json2yaml({ $comment: "before", Constraints: {}, TestCases: [] }),
      "#before\n\nTestCases: []\n",
      "test suite as JSON"
    );
  });

  it("convert typical test suite", () => {
    assert.deepStrictEqual(
      json2yaml({
        $comment: "This\n goes\n  first",
        Constraints: { foo: ["Foo1", "Foo2", "Foo3"], bar: ["Bar1"], baz: [] },
        TestCases: [
          {
            Name: "first test case",
            Rule: "first-rule",
            Input: "first input",
          },
          {
            Name: "second test case",
            Rule: "second-rule",
            Input: "second input",
            FailAt: 42,
          },
          {
            Name: "third test case",
            Rule: "first-rule",
            Input: "third input",
          },
        ],
      }).split("\n"),
      [
        "#This",
        "# goes",
        "#  first",
        "",
        "Constraints:",
        "  foo:",
        "    - Foo1",
        "    - Foo2",
        "    - Foo3",
        "  bar:",
        "    - Bar1",
        "  baz: []",
        "",
        "TestCases:",
        "  ",
        "  - Name: first test case",
        "    Rule: first-rule",
        "    Input: first input",
        "",
        "  - Name: second test case",
        "    Rule: second-rule",
        "    Input: second input",
        "    FailAt: 42",
        "",
        "  - Name: third test case",
        "    Rule: first-rule",
        "    Input: third input",
        "",
      ],
      "YAML"
    );
  });
});
