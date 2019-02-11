import requests

base_url = 'https://www.cordcloud.cc'


def checkin():
    email = "68754807@qq.com";
    password = "shadowsocks";

    email = email.split('@')
    email = email[0] + '%40' + email[1]

    session = requests.session()
    login_url = base_url + '/auth/login'
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36',
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    }
    post_data = 'email=' + email + '&passwd=' + password + '&code=&remember_me=week'
    post_data = post_data.encode()
    response = session.post(login_url, post_data, headers=headers, verify=False)
    print(response.text)

    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36',
        'Referer': base_url + '/user'
    }

    response = session.post(base_url + '/user/checkin', headers=headers)

while True:
    try:
        checkin()
    except Exception:
        continue
    break