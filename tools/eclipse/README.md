# Eclipse project `odata-abnf`

This Eclipse project allows editing the [OData ABNF and testcase files](../../abnf). 


 ## Installation
 
Depending on your machine either follow the installation steps for [Linux bash](../bash/README.md) or [Windows PowerShell](../PowerShell/README.md).

Import the Eclipse project `odata-abnf`:
- Menu "File" > "Import"
- Select import wizard "Existing Projects into Workspace"
- Press "Next >"
- Select root directory `<git clone target directory>/odata-abnf/tools/eclipse`
- Press "Finish"

Enable syntax check and auto-completion for the testcase XML files: 
- Menu "Window" > "Preferences"
- Select "XML" > "XML Catalog"
- Press "Add..."
- Press "File System..."
- Select `<git clone target directory>/abnf-test-tool/TestCases.xsd` and press "Open"
- Press "OK"


## Usage

Each time one of the ABNF files is changed and saved, a parser will be generated, with a verbose log in the Console view. If it ends in something like

```  
   -        -        -        -        -        -  VCHAR
   -        -        -        -        -        -  waitPreference
   -        -        -        -        -        -  year
   -        o        -        -        -        -  yearMethodCallExpr
   -        -        -        -        -        -  zeroToFiftyNine
```

everything is fine. Otherwise use the log to identify the bug you just edited into the ABNF :smiley:

To run the testcases, use run configuration `Check OData ABNF`. The Console view should show something like

```
Running test cases from ../../abnf/odata-abnf-testcases.xml
All 732 test cases passed

Running test cases from ../../abnf/odata-aggregation-testcases.xml
All 89 test cases passed

Running test cases from ../../abnf/odata-temporal-testcases.xml
All 8 test cases passed

477 of 477 rules covered (100%)
```

I find it convenient to just press `F11` in the XML editor to re-run all testcases: select "Window" > "Preferences" > "Run/Debug" > "Launching", then in the bottom-most group "Launch Operation" select the first radio button "Always launch the previously launched application".