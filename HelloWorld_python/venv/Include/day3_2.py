#!/usr/bin/env python
# coding=utf-8
import random
def fun(p):
    for i in range(len(p)):
        j = random.randint(0,i)
        p[j], p[j-1] = p[j-1], p[j]
    return p


print(fun(11))