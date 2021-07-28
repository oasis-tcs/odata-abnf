// Convert XML testcases to JSON and from there to YAML

const sax = require("sax");
const YAML = require("yaml");

//TODO: extract to separate "binary" script
// const fs = require("fs");
// // const { readXml, json2yaml } = require("./convertTestuite");
// const abnfFolder = "./abnf/";

// fs.readdirSync(abnfFolder)
//   .filter((fn) => fn.endsWith(".xml"))
//   .forEach((xmlfile) => {
//     const example = xmlfile.substring(0, xmlfile.lastIndexOf("."));
//     console.log(xmlfile);
//     fs.writeFileSync(
//       abnfFolder + example + ".yaml",
//       json2yaml(readXml(fs.readFileSync(abnfFolder + xmlfile, "utf8"), true))
//     );
//   });

function readXml(xml, withHeaderComment) {
  const testsuite = { Constraints: {}, TestCases: [] };
  const parser = sax.parser(true);
  const current = {};

  if (withHeaderComment)
    parser.oncomment = function (comment) {
      if (!current.inSuite)
        testsuite.$comment = comment
          .replace(/\r/g, "")
          .replace(/^\n*|\n*$/g, "");
    };

  parser.onopentag = function (node) {
    switch (node.name) {
      case "TestSuite":
        current.inSuite = true;
        break;
      case "Constraint":
        if (!testsuite.Constraints[node.attributes.Rule])
          testsuite.Constraints[node.attributes.Rule] = [];
        current.constraint = testsuite.Constraints[node.attributes.Rule];
        break;

      case "Input":
        current.text = null;
        break;

      case "Match":
        current.text = null;
        break;

      case "TestCase":
        current.testcase = {};
        current.testcase.Name = node.attributes.Name;
        current.testcase.Rule = node.attributes.Rule;
        if (node.attributes.FailAt)
          current.testcase.FailAt = parseInt(node.attributes.FailAt, 10);
        testsuite.TestCases.push(current.testcase);
        break;
    }
  };
  parser.ontext = function (text) {
    current.text = text;
  };
  parser.onclosetag = function (name) {
    switch (name) {
      case "Input":
        current.testcase.Input = current.text || "";
        break;

      case "Match":
        current.constraint.push(current.text);
        break;
    }
  };

  parser.write(xml).close();

  return testsuite;
}

function json2yaml(testsuite) {
  // see https://eemeli.org/yaml/v1/#creating-documents
  const yaml = new YAML.Document();

  const foo = YAML.createNode(testsuite);
  yaml.contents = foo;

  if (testsuite.$comment) {
    yaml.commentBefore = testsuite.$comment;
    yaml.delete("$comment");
  }

  // space before TestCases and each test case
  yaml.contents.items[1].spaceBefore = true;
  for (const item of yaml.contents.items[1].value.items) {
    item.spaceBefore = true;
  }

  // remove Constraints if empty
  if (Object.keys(testsuite.Constraints).length == 0) {
    yaml.contents.items[1].spaceBefore = false;
    yaml.delete("Constraints");
  }

  return String(yaml);
}

module.exports = { readXml, json2yaml };
