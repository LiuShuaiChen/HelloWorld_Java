import time

print(time.time())


print(type(time.asctime( time.localtime(time.time()))))

print(time.asctime(time.localtime(time.time())))

print(time.asctime(time.localtime(time.time())))

dt = time.strftime("%Y%m%d%H%M%S", time.localtime(time.time()))
print(dt)