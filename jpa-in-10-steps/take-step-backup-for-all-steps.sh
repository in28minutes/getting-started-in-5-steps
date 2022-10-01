#!/bin/bash

## take-step-backup-for-all-steps:


# Find git repos and loop over them:
for repo in `find * -type d`
do
    
	echo -e "${repo}"
    java -cp /Ranga/git/local-automation-projects/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat ${repo} >> ${repo}.md

done
