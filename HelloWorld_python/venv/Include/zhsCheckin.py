import requests

url='https://zhs.ooo/auth/login'
userurl='https://zhs.ooo/user'
headers={'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36',
         'accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8'}
data={'email':'xxxx@qq.com','passwd':'xxxx'}
session=requests.session()
session.post(url,headers=headers,data=data)
userrespond=session.get(userurl,headers=headers,cookies=respond.cookies)
checkinurl = 'https://zhs.ooo/user/checkin'
checkinrepond=session.post(checkinurl,headers=headers,cookies=respond.cookies)
print(checkinrepond.text)