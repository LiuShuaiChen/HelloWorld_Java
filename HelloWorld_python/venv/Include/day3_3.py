#!/usr/bin/env python
# coding=utf-8
import datetime
before = datetime.datetime.now()
p = (i for i in range(100000000))
end = datetime.datetime.now()
print ((end-before).total_seconds())

before = datetime.datetime.now()
p = (i for i in xrange(100000000))
end = datetime.datetime.now()
print (end-before).total_seconds()
# print p.next()
# print range(10)
# for i in xrange(10):
#     print i
# q = xrange(10)