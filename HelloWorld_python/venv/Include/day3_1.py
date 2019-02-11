#!/usr/bin/env python
# coding=utf-8
# from day3_2 import *

import random

q = [9, 3, 5, 6, 2, 8, 1]
# for i in range(len(p)):
#     for j in range(len(p)-1-i):
#         print p[j], p[j+1]
#         if p[j] > p[j+1]:
#             p[j], p[j+1] = p[j+1], p[j]
# print p


# for m in range(10):
#     random.shuffle(q)
#     print q


p = [1, 2, 3, 2, 3, 4, 1, 2, 3]
# p1 = []
# for i in p:
#     if i not in p1:
#         p1.append(i)
# print p1
p1 = set(p)
print( list(p1))
