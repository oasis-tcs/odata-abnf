const { readXml } = require("../lib/convertTestcases");
const assert = require("assert");

describe("read XML", () => {
  it("typical test suite", () => {
    assert.deepStrictEqual(
      readXml(
        `<!-- header comment -->    
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
      }
    );
  });
});
