// Convert XML testcases to YAML

const fs = require("fs");
const sax = require("sax");
const YAML = require("yaml");

//TODO: wrap as function or extract to separate "binary" script
// const abnfFolder = "./abnf/";
// fs.readdirSync(abnfFolder)
//   .filter((fn) => fn.endsWith("odata-temporal-testcases.xml")) //TODO: just .xml
//   .forEach((xmlfile) => {
//     const example = xmlfile.substring(0, xmlfile.lastIndexOf("."));
//     console.log(xmlfile);

//     const xml = fs.readFileSync(abnfFolder + xmlfile, "utf8");
//     const json = readXml(xml);

//     //TODO: convert to YAML
//     //TODO: output YAML
//     // console.dir(yaml.toString());
//     // fs.writeFileSync(
//     //   abnfFolder + example + ".yml", //TODO: .yaml once it works
//     //   JSON.stringify(json, null, 4)
//     // );
//   });

function readXml(xml) {
  const testsuite = { Constraints: {}, TestCases: [] };
  const parser = sax.parser(true);
  const current = {};
  //TODO: parser.oncomment
  parser.onopentag = function (node) {
    switch (node.name) {
      case "Constraint":
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
          current.testcase.FailAt = node.attributes.FailAt;
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
        current.testcase.Input = current.text;
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
  const yaml = new YAML.Document();
  yaml.commentBefore = " A commented document";
  yaml.contents = { Constraints: {}, TestCases: [] };

  //TODO: everything

  return yaml;
}

module.exports = { readXml };
