# `check-abnf.ps1` for Windows PowerShell

This script compiles the three [OData ABNF files](../../abnf) into a parser using the Java APG fork from https://github.com/ralfhandl/apg-java.

It then executes all tests in the three testcase XML files using the generated parser and the ABNF test tools from https://github.com/SAP/abnf-test-tool.


 ## Installation
 
 You need a [Java SE JDK](http://jdk.java.net) and [Git](https://git-scm.com/download/win) installed and in the PATH. Then the script will clone the repositories
- https://github.com/ralfhandl/apg-java and
- https://github.com/SAP/abnf-test-tool

next to this project and build the required `apg.jar` and `abnf-test-tool.jar` files on first use.


## Usage

In the `PowerShell` folder execute
```sh
./check-abnf.ps1
```

This should result in something like
```
Running test cases from ../../abnf/odata-abnf-testcases.xml
All 732 test cases passed

Running test cases from ../../abnf/odata-aggregation-testcases.xml
All 89 test cases passed

Running test cases from ../../abnf/odata-temporal-testcases.xml
All 8 test cases passed

477 of 477 rules covered (100%)
```
