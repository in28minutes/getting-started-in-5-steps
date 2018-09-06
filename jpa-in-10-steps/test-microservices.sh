#!/bin/bash

## gitcheck:
##   Check all git repositories in subdirectories, and list the ones with changes
##   30/07/2011, AstroFloyd, bzrcheck
##   18/01/2013, Astrofloyd, gitcheck

# Initialise counters:
let count_all=0
let count_changed=0
let count_unchanged=0

# Set to 1 for more verbose output:
let verbose=0

# Find git repos and loop over them:
for repo in `find . -name "pom.xml"`
do
    
    # cd to the dir that contains pom.xml/:
    dir=`echo ${repo} | sed -e 's/\/pom.xml/\//'`
    cd ${dir}
    
    # If there are changes, print some status and branch info of this repo:
    mvn spring-boot:run
    
    # cd back:
    cd - &> /dev/null
done

# From https://astrofloyd.wordpress.com/2013/02/10/gitcheck-check-all-your-git-repositories-for-changes/
cd 