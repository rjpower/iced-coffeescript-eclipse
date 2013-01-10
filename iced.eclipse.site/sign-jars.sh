#!/bin/bash

for jarfile in */*.jar; do
    echo Signing $jarfile
	jarsigner $* $jarfile personal
done
