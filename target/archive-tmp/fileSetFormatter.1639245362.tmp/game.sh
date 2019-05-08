#!/bin/sh

BASE=`dirname $0`
java -jar -Djava.library.path="$BASE/lib/" "$BASE/Chess-1.6.79.jar"
