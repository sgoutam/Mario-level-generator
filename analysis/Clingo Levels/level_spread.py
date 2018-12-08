#! /usr/bin/env python3

'''
    author: Sanket Goutam
'''

import numpy as np



for f in range(0,25):
    level_map = np.zeros(shape=(100,4))
    filename = 'input_'+str(f) +'.txt'
    with open(filename) as f:
        lines = f.readlines()

    for idx,line in enumerate(lines):
        #print("idx"+ str(idx) + "line:" + str(line))
        level_map[int(idx%100), int(idx/100)] = line

    #print(level_map)

    spread_ = np.zeros(5)

    idx = -1
    for j in range(0,100):
        if(j%20) == 0:
            idx = idx+1
        for i in range(0,4):
            if(level_map[j,i] not in [0,1,3,18,19]):
                spread_[idx] = spread_[idx] + 1

    print(spread_)
