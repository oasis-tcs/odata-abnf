# Eclipse project `odata-abnf`

This Eclipse project allows editing the three [OData ABNF files](../../abnf) and their testcase files. 


... Each time changes to  into a parser using the Java APG fork from https://github.com/ralfhandl/apg-java.

... It then executes all tests in the three testcase XML files using the generated parser and the ABNF test tools from https://github.com/SAP/abnf-test-tool.


 ## Installation
 
Depending on your machine either follow the installation steps for [Linux bash](../bash/README.md) or [Windows PowerShell](../PowerShell/README.md).

In Eclipse, ... import ...


## Usage

... copy from abnf-test-tool description

Launch run configuration `Check OData ABNF`. The console is should show something like

```
Running test cases from ../../abnf/odata-abnf-testcases.xml
All 732 test cases passed

Running test cases from ../../abnf/odata-aggregation-testcases.xml
All 89 test cases passed

Running test cases from ../../abnf/odata-temporal-testcases.xml
All 8 test cases passed

477 of 477 rules covered (100%)
```
