

# converting ABNF to syntax diagrams

```bash
npm install -g abnf-to-railroad@0.0.5

abnf-to-railroad --help

cd syntax-diagram 

abnf-to-railroad ../abnf/odata-abnf-construction-rules.txt odata-syntax.html
```

## tool sources

[railroad-syntax-diagram.js](https://github.com/xtofs/railroad-syntax-diagram.js)

## Issues

A common Windows npm issue is that the global install succeeded,
but the npm global bin directory isn't in your Windows PATH.

Here's how to fix it:

```ps1
Add-Content $PROFILE "`n# Add npm global packages to PATH`n`$env:PATH += ';C:\Users\chrispre\AppData\Roaming\npm'"
```
