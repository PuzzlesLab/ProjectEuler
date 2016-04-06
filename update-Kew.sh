#!/bin/sh
git pull origin master
now="$(date): update all by Kew"

git add -A README.md
git add -A Kew/*.java
git add -A update-Kew.sh

git commit -m "$now"
git push origin master