const fs = require("fs");
const YAML = require("yaml");

const { runTestSuite, printRuleCoverage } = require("./runTests");

const abnfFolder = "../../abnf/";

fs.readdirSync(abnfFolder)
  .filter((fn) => fn.endsWith(".yaml"))
  .forEach((file) => {
    console.log(`${file}`);
    const testSuite = YAML.parse(fs.readFileSync(abnfFolder + file, "utf8"));
    runTestSuite(testSuite).map((line) => console.log(line));
  });

console.log(printRuleCoverage());

process.exit(process.exitCode);
