#!/usr/bin/sh

[ -z "$AOC_SESSION" ] && export AOC_SESSION="53616c7465645f5f00b02f826aaad7d568f2fd84b3f3eddabf721bc5886fc826b56cb13e18c9085a3a1dbcc54650a796"

today=$(date +"%e" | sed 's/\s\+//')
file="resources/day$today/input"
[ -n $file ] && sudo rm $file && echo "old file removed"

curl --cookie "session=$AOC_SESSION" https://adventofcode.com/2021/day/$today/input > $file && chmod 444 $file
