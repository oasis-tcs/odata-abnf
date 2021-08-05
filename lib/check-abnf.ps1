<# 
.SYNOPSIS
    Unit test for OData ABNF grammar

.DESCRIPTION
    This script compiles the three OData ABNF files into a parser using https://github.com/ldthomas/apg-js

    It then executes all tests in the three testcase files using the generated parser

    Prerequisites
    - PowerShell (https://docs.microsoft.com/en-us/powershell/scripting/install/installing-powershell)
    - Node.js    (https://nodejs.org/)

    In the root folder of this project run
    - npm install 
#>

param (
    [switch]$watch = $false
)

$Grammar = "lib/grammar.js"

function CompileAndCheck {
    if (!(Test-Path $Grammar) -or ($Null -eq (Get-Content $Grammar)) -or
        (get-item $Grammar).LastWriteTime -lt (get-item "abnf/odata-abnf-construction-rules.txt").LastWriteTime -or 
        (get-item $Grammar).LastWriteTime -lt (get-item "abnf/odata-aggregation-abnf.txt").LastWriteTime -or
        (get-item $Grammar).LastWriteTime -lt (get-item "abnf/odata-temporal-abnf.txt").LastWriteTime ) {

        node node_modules/apg-js/bin/apg.sh -i "abnf/odata-abnf-construction-rules.txt,abnf/odata-aggregation-abnf.txt,abnf/odata-temporal-abnf.txt" -o lib/grammar.js  | Select-String -Pattern "^line no:", "^ORIGINAL GRAMMAR", "^Annotated Input Grammar", "^$" -NotMatch 

        if ($Null -eq (Get-Content $Grammar) ) { return }
        Write-Output " "
    }

    # run tests	
    node lib/checkAbnf.js
}

CompileAndCheck

if ($watch) {
    $PathToMonitor = Resolve-Path "$pwd\abnf"
    $WaitMessage = "Waiting for changes (press ^C to stop)..."

    $FileSystemWatcher = New-Object System.IO.FileSystemWatcher
    $FileSystemWatcher.Path = $PathToMonitor
    $FileSystemWatcher.IncludeSubdirectories = $true

    Write-Output $WaitMessage
    while ($true) {            
        $Change = $FileSystemWatcher.WaitForChanged('All', 1000)
        if ($Change.TimedOut -eq $false) {
            Write-Output " "
            CompileAndCheck
            Write-Output $WaitMessage
        }
    }
}

exit $LASTEXITCODE
