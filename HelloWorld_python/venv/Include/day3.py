#!/usr/bin/env python
# coding=utf-8
import datetime,time
before = datetime.datetime.now()
pn = "18911010345"
ps = ["130", "131", "132", "133", "135", "138", "139", "189", "180"]
if len(pn) == 11 and pn.isdigit() and pn[:3] in ps:
    print("legal")
else:
    print("illegal")
end = datetime.datetime.now()
print ((end-before).total_seconds())

########################################################################
before = datetime.datetime.now()
pn = "18911010345"
ps = ["130", "131", "132", "133", "135", "138", "139", "189", "180"]
flag = 0
if len(pn) == 11 and pn.isdigit():
    for p in ps:
        if pn.startswith(p):
            flag = 1
a = "legal" if flag else "illegal"
print(a)
end = datetime.datetime.now()
print ((end-before).total_seconds())