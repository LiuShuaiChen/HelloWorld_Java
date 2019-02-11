#coding=utf-8
import requests
import time
import random
import json
from lxml import etree
import sys

# reload(sys)
# sys.setdefaultencoding('utf8');

global url
url = 'https://zhs.ooo/auth/login';

global userurl
userurl = 'https://zhs.ooo/user';

global headers
headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36',
        'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8'};

global respond
global data
data = {'email': 'xxxx', 'passwd': 'xxxx'};

global session
session = requests.session();

global resultMsg
resultMsg = "少侠纵有一身正气，百般武艺，奈何却无此好运，只能奉献 1000MB 赏银，看天下英雄谁能擒得采花贼，一解心头之恨...";


def getCookies():
    session.post(url, headers=headers, data=data);

getCookies();

log = open("./log/"+time.strftime("%Y%m%d%H%M%S", time.localtime(time.time())), 'a+');
while 1==1:
    try:
        respond = session.post(url, headers=headers, data=data);
    except:
        time.sleep(100);
        # print >> log, "异常发生了..............................." + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()));
        print("异常发生了..............................." + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time())));
        log.flush();
        getCookies();
        respond = session.post(url, headers=headers, data=data);

    if(respond.status_code != 200):
        getCookies();
        respond = session.post(url, headers=headers, data=data);
    html = etree.HTML(respond.text);
    html_data = html.xpath('//code');
    resultCode = int(html_data[1].text[0:-3]);
    if (respond.status_code == 503):
        # 遇到ddos防火墙
        # print >> log, respond.status_code + " " + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()));
        print(respond.status_code + " " + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time())))
        # print(respond.status_code)
    else:
        try:
            userrespond = session.get(userurl, headers=headers, cookies=respond.cookies);
        except:
            # print >> log, "异常还是发生了............................... " + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()));
            print("异常发生了..............................." + time.strftime("%Y-%m-%d %H:%M:%S",time.localtime(time.time())));
            log.flush();
            time.sleep(100);
            userrespond = session.get(userurl, headers=headers, cookies=respond.cookies);

        checkinurl = 'https://zhs.ooo/user/xtongji';

    # 临时变量 如果赏金榜流量没有变化 则不需要再输出
    if resultCode > 3000:
        print("赏金榜流量是 " + html_data[1].text + ' ' + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time())));
        # print >> log, "赏金榜流量是 " + html_data[1].text + ' ' + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()));
        log.flush();

    while resultCode > 10000:
        checkinrepond = session.post(checkinurl, headers=headers, cookies=respond.cookies);
        obj = json.loads(checkinrepond.text);
        objMsg = str(obj.get('msg'));
        # print >> log, objMsg;
        print(objMsg);
        log.flush()
        if(objMsg != resultMsg):
            break;

log.closed();
