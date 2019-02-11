#!/usr/bin/env python
# coding=utf-8
import random
from operator import add, sub
def play(n):
    count = 0
    for i in range(10):
        a = random.randint(1,(n+1)*10 - 1)
        b = random.randint(1,(n+1)*10 - 1)
        p = [a, b]
        p.sort(reverse=True)
        a, b = p
        ops = {"+":add, "-":sub}
        d = random.choice(["+", "-"])
        c = raw_input("%d%s%d="%(a, d, b))
        if ops[d](a, b) == int(c):
            count += 1
            print (u"√")
        else:
            print (u"×")
    return count
for j in range(10):
    print (u"第%d关游戏开始,游戏规则，%d内数字相加减"%(j+1, (j+1)*10))
    ct = play(j)
    if ct >8:
        print (u"第%d关通过"%(j+1))
        continue
    else:
        print (u"第%d关失败"%(j+1))
        break
