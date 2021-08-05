<# 
.SYNOPSIS
    Unit test for OData ABNF grammar

.DESCRIPTION
    This script compiles the three OData ABNF files into a parser using the Java APG fork from https://github.com/ralfhandl/apg-java

    It then executes all tests in the three testcase files using the parser and the ABNF test tools from https://github.com/SAP/abnf-test-tool

    Prerequisites 
    - Java SDK         http://jdk.java.net
    - Git              https://git-scm.com/download/win 
#>

param (
    [switch]$watch = $false
)

if ($null -eq (Get-Command "javac.exe" -ErrorAction SilentlyContinue)) { Write-Output "Cannot find javac.exe in PATH, please install a Java SE JDK"; exit 1 }
if ($null -eq (Get-Command "java.exe"  -ErrorAction SilentlyContinue)) { Write-Output "Cannot find java.exe in PATH, please install a Java SE JDK"; exit 1 }


# check for apg.jar, make it if missing
if ( !(Test-Path "../../../apg-java/build/apg.jar") ) { 
    if ($null -eq (Get-Command "git.exe"   -ErrorAction SilentlyContinue)) { Write-Output "Cannot find git.exe in PATH, please install Git"; exit 1 }
    if ($null -eq (Get-Command "jar.exe"   -ErrorAction SilentlyContinue)) { Write-Output "Cannot find jar.exe in PATH, please install a Java SE JDK"; exit 1 }

    Push-Location "../../.."
    Write-Output "make apg.jar"

    if ( !(Test-Path "apg-java") ) {
        git clone https://github.com/ralfhandl/apg-java
        if (!$?) { Pop-Location; Write-Output "Could not clone apg-java"; exit 1 }
    }

    Set-Location "apg-java"
    if ( !(Test-Path "bin") ) { mkdir "bin" >$null }
    javac -d bin src/apg/*.java
    if (!$?) { Pop-Location; Write-Output "Could not compile apg-java"; exit 1 }

    Set-Location "build"
    jar cmf apg.mf apg.jar -C ../bin .
    if (!$?) { Pop-Location; Write-Output "Could not create apg.jar"; exit 1 }

    Pop-Location
}

# check for abnf-test-tool.jar, build it if missing
if ( !(Test-Path "../../../abnf-test-tool/build/abnf-test-tool.jar") ) { 
    if ($null -eq (Get-Command "git.exe"   -ErrorAction SilentlyContinue)) { Write-Output "Cannot find git.exe in PATH, please install Git"; exit 1 }
    if ($null -eq (Get-Command "jar.exe"   -ErrorAction SilentlyContinue)) { Write-Output "Cannot find jar.exe in PATH, please install a Java SE JDK"; exit 1 }

    Push-Location "../../.."
    Write-Output "make abnf-test-tool.jar"

    if ( !(Test-Path "abnf-test-tool") ) {
        git clone https://github.com/SAP/abnf-test-tool
        if (!$?) { Pop-Location; Write-Output "Could not clone abnf-test-tool"; exit 1 }
    }

    Set-Location "abnf-test-tool"
    if ( !(Test-Path "bin") ) { mkdir "bin" >$null }
    javac -cp ../apg-java/build/apg.jar -d bin src/checker/*.java
    if (!$?) { Pop-Location; Write-Output "Could not compile abnf-test-tool"; exit 1 }

    Set-Location "build"
    jar cmf abnf-test-tool.mf abnf-test-tool.jar -C ../bin checker
    if (!$?) { Pop-Location; Write-Output "Could not create abnf-test-tool.jar"; exit 1 }

    Pop-Location
}

function CompileAndCheck {
    # generate parser for ABNF
    if ( !(Test-Path "grammar") ) { mkdir "grammar" >$null }

    if ( !(Test-Path "grammar/GrammarUnderTest.java") -or
        (get-item "grammar/GrammarUnderTest.java").LastWriteTime -lt (get-item "../../abnf/odata-abnf-construction-rules.txt").LastWriteTime -or 
        (get-item "grammar/GrammarUnderTest.java").LastWriteTime -lt (get-item "../../abnf/odata-aggregation-abnf.txt").LastWriteTime -or
        (get-item "grammar/GrammarUnderTest.java").LastWriteTime -lt (get-item "../../abnf/odata-temporal-abnf.txt").LastWriteTime ) {

        Write-Output "Compiling ABNF..."

        Remove-Item grammar/GrammarUnderTest*

        java.exe -cp ../../../apg-java/build/apg.jar apg/Generator /in=../../../abnf/odata-abnf-construction-rules.txt /in=../../../abnf/odata-aggregation-abnf.txt /in=../../../abnf/odata-temporal-abnf.txt /package=grammar /java=GrammarUnderTest /dir=grammar/ /dv >grammar/apg.log

        select-string -pattern "^\*\*\* java.lang.Error|^line" -casesensitive -path grammar/apg.log | Select-Object -exp line

        if ( !(Test-Path "grammar/GrammarUnderTest.java") ) { return }
    }

    # compile parser
    if ( !(Test-Path "grammar/GrammarUnderTest.class") -or
        (get-item "grammar/GrammarUnderTest.java").LastWriteTime -gt (get-item "grammar/GrammarUnderTest.class").LastWriteTime ) {

        javac.exe -cp ../../../apg-java/build/apg.jar grammar/GrammarUnderTest.java
        if (!$?) { return }
    }

    # run tests	
    java.exe -cp "../../../apg-java/build/apg.jar;../../../abnf-test-tool/build/abnf-test-tool.jar;." checker.Check ../../abnf/odata-abnf-testcases.xml ../../abnf/odata-aggregation-testcases.xml ../../abnf/odata-temporal-testcases.xml
}

CompileAndCheck

if ($watch) {
    $PathToMonitor = Resolve-Path "$pwd\..\..\abnf"

    $FileSystemWatcher = New-Object System.IO.FileSystemWatcher
    $FileSystemWatcher.Path = $PathToMonitor
    $FileSystemWatcher.IncludeSubdirectories = $true
    
    Write-Host "Monitoring content of $PathToMonitor"
    
    while ($true) {
        $Change = $FileSystemWatcher.WaitForChanged('All', 1000)
        if ($Change.TimedOut -eq $false) {
            CompileAndCheck
        }
    }
}