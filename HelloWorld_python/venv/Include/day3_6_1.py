#!/usr/bin/env python
# coding=utf-8
import random
while True:
    p = [1,2,3,4,5,6,7,8,9]
    a1 = random.choice(p)
    a2 = random.choice(p)
    a3 = random.choice(p)
    a4 = random.choice(p)
    a5 = random.choice(p)
    a6 = random.choice(p)
    a7 = random.choice(p)
    a8 = random.choice(p)
    a9 = random.choice(p)
    a = "%d%d%d%d"%(a1,a2,a3,a4)
    b = "%d"%a5
    c = "%d%d%d%d"%(a6,a7,a8,a9)
    print (a,b,c)
    q = a+b+c
    q = [int(i) for i in q]
    q.sort()
    p.sort()
    if int(a)*int(b) == int(c) and q == p:
        print (a,b,c)
        break