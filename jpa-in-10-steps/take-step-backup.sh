echo '<!---'  >> $1.md
echo Current Directory : $PWD >> $1.md
echo '-->' >> $1.md
java -cp /ProgrammingExcellence/Workspaces/Rithus.com/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat $PWD >> $1.md
zip -r $1.zip . -x "target/*" -x "node_modules/*"  -x ".mvn/*" -x ".settings/*" -x ".*" -x ".*/*" -x "**/.*" -x "*.md" -x "**/*.md" -x "**/mvn*" -x "*.zip" -x "**/*.zip" -x "/**/target/*" -x "/**/.mvn/*" -x "/**/.settings/*" -x "/**/node_modules/*" 