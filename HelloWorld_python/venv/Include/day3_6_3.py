#!/usr/bin/env python
# coding=utf-8
import random,datetime
before = datetime.datetime.now()
p = [1,2,3,4,5,6,7,8,9]
while True:
    a = random.sample(p, 4)
    _a = list(set(p)-set(a))
    b = random.sample(_a, 1)
    c = list(set(_a)-set(b))
    a1 = "".join([str(i) for i in a])
    b1 = "".join([str(i) for i in b])
    c1 = "".join([str(i) for i in c])
    if sorted(str(int(a1)*int(b1))) == sorted(c1):
        print a1,b1,c1
        end = datetime.datetime.now()
        print (end-before).total_seconds()

