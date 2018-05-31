# `check-abnf` for Linux bash

This script compiles the three [OData ABNF files](../../abnf) into a parser using the Java APG fork from https://github.com/ralfhandl/apg-java.

It then executes all tests in the three testcase XML files using the generated parser and the ABNF test tools from https://github.com/SAP/abnf-test-tool.


 Prerequisites
 - Java SDK         sudo apt-get install default-jdk
 - Java APG         clone https://github.com/ralfhandl/apg-java, go to 'build' subdirectory, there run './make-jars'
 - ABNF test tool   clone https://github.com/SAP/abnf-test-tool, go to 'build' subdirectory, there run './make-jar' (singular :-)


## Installation

First you need a Java SDK:
```sh
sudo apt-get install default-jdk
```

Then clone https://github.com/ralfhandl/apg-java next to this project and build the `apg.jar` file:
```sh
git clone https://github.com/ralfhandl/apg-java
cd apg-java/build
./make-jars
```

Finally clone https://github.com/SAP/abnf-test-tool next to this project and build the `abnf-test-tool.jar` file:
```sh
git clone https://github.com/SAP/abnf-test-tool
cd abnf-test-tool-java/build
./make-jar
```


## Usage

In the `bash` folder execute
```sh
./check-abnf
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
