#!/usr/bin/env python
# coding=utf-8
from itertools import permutations
import datetime
before = datetime.datetime.now()
p = [1,2,3,4,5,6,7,8,9]
s = permutations(p)
for s1 in s:
    a1 = "".join([str(i) for i in s1[:4]])
    b1 = str(s1[4])
    c1 = "".join([str(i) for i in s1[5:]])
    if int(a1) * int(b1) == int(c1):
        print a1,b1,c1
end = datetime.datetime.now()
print (end-before).total_seconds()