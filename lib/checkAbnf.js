const fs = require("fs");
// const YAML = require("yaml");

//TODO: receive text and write to console

const { readXml } = require("./convertTestsuite");
const { runTestSuite, printRuleCoverage } = require("./runTests");

const abnfFolder = "./abnf/";

fs.readdirSync(abnfFolder)
  //TODO: switch to *.yaml and use YAML.parse(...)
  .filter((fn) => fn.endsWith(".xml"))
  .forEach((xmlfile) => {
    console.log(`${xmlfile}`);
    const testSuite = readXml(fs.readFileSync(abnfFolder + xmlfile, "utf8"));
    console.log(runTestSuite(testSuite));
  });

console.log(printRuleCoverage());
