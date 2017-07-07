java -cp /ProgrammingExcellence/Workspaces/Rithus.com/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat >> $1.md
zip -r $1.zip . -x "target/*" -x ".*/*" -x ".*" -x "*.md" -x "mvn*" -x "*.zip"
git add *; git commit -m "$1"; git push;
