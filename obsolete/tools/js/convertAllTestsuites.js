// Convert all test suites from XML to YAML

const fs = require("fs");
const { readXml, json2yaml } = require("./convertTestsuite");

const abnfFolder = "./abnf/";

fs.readdirSync(abnfFolder)
  .filter((fn) => fn.endsWith(".xml"))
  .forEach((xmlfile) => {
    const example = xmlfile.substring(0, xmlfile.lastIndexOf("."));
    console.log(xmlfile);
    fs.writeFileSync(
      abnfFolder + example + ".yaml",
      json2yaml(readXml(fs.readFileSync(abnfFolder + xmlfile, "utf8"), true))
    );
  });
