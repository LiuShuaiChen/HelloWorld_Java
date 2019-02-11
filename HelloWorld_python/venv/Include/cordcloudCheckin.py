import requests

url='https://www.cordcloud.cc/auth/login'
userurl='https://www.cordcloud.cc/user'
headers={'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36'}
data={'email':'68754807@qq.com','passwd':'shadowsocks'}
session=requests.session()
respond=session.post(url,headers=headers,data=data)
#print(respond.text)
userrespond=session.get(userurl,headers=headers,cookies=respond.cookies)
#print(userrespond.text)
checkinurl='https://www.cordcloud.cc/user/checkin'
checkinrepond=session.post(checkinurl,headers=headers,cookies=respond.cookies)
print(checkinrepond.text)