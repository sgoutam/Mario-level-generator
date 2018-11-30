#!/bin/bash
clingo --rand-freq=0.1 --seed=$RANDOM BasicVersion1.lp > trial2.txt  ;


echo $RANDOM ;


cat trial2.txt  ;


python3 test.py  ;