#!/usr/bin/env python
# coding=utf-8
import random
p = [1,2,3,4,5,6,7,8,9]
while True:
    a = random.sample(p, 4)
    b = random.sample(p, 1)
    c = random.sample(p, 4)
    q = a+b+c
    a1 = "".join([str(i) for i in a])
    b1 = "".join([str(i) for i in b])
    c1 = "".join([str(i) for i in c])
    p.sort()
    q.sort()
    print a1,b1,c1
    if int(a1)*int(b1) == int(c1) and p == q:
        print a1,b1,c1
        break