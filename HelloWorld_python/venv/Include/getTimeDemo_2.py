import http.client
import time
import os


def get_webservertime(host):
    conn = http.client.HTTPConnection(host)
    conn.request("GET", "/")
    r = conn.getresponse()
    # r.getheaders() #获取所有的http头
    ts = r.getheader('date')  # 获取http头date部分
    # 将GMT时间转换成北京时间
    ltime = time.strptime(ts[5:25], "%d %b %Y %H:%M:%S")
    print(ltime)
    ttime = time.localtime(time.mktime(ltime) + 8 * 60 * 60)
    print(ttime)
    dat = "date -s %u-%02u-%02u" % (ttime.tm_year, ttime.tm_mon, ttime.tm_mday)
    tm = "date -s %02u:%02u:%02u" % (ttime.tm_hour, ttime.tm_min, ttime.tm_sec)

    # 获取服务器端时间
    print(dat, tm)

    # 获取本地时间
    print(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))

get_webservertime('www.baidu.com')
