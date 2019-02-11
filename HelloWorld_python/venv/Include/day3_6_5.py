#!/usr/bin/env python
# coding=utf-8
import copy,datetime
before = datetime.datetime.now()
p = [1,2,3,4,5,6,7,8,9]
for i in p:
    q = copy.copy(p)
    q.remove(i)
    for j in q:
        t = copy.copy(q)
        t.remove(j)
        for k in t:
            s = copy.copy(t)
            s.remove(k)
            for l in s:
                w = copy.copy(s)
                w.remove(l)
                for m in w:
                    x = copy.copy(w)
                    x.remove(m)
                    a = str(i)
                    b = "%d%d%d%d"%(j,k,l,m)
                    c = "".join([str(y) for y in x])
                    ab = sorted(str(int(a)*int(b)))
                    ac = sorted(c)
                    if ac == ab:
                        print a,b,str(int(a)*int(b))
end = datetime.datetime.now()
print (end-before).total_seconds()