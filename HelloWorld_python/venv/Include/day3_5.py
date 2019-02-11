#!/usr/bin/env python
# coding=utf-8
import random
from operator import add, sub
def play(n):
    print u"第%d关游戏开始,游戏规则，%d内数字相加减"%(n, n*10)
    count = 0
    for i in range(10):
        p = random.sample(range(1,n*10), 2)
        p.sort(reverse=True)
        a, b = p
        ops = {"+":add, "-":sub}
        d = random.choice(["+", "-"])
        c = raw_input("%d%s%d="%(a, d, b))
        if ops[d](a, b) == int(c):
            count += 1
            print u"√"
        else:
            print u"×"
    if count > 8:
        print u"第%d关通过"%(n)
        n += 1
        play(n)
    else:
        print u"第%d关失败"%(n)
        flag = raw_input(u"是否继续游戏，继续请输入Y")
        if flag.upper().startswith("Y"):
            play(n)
        else:
            return
play(1)