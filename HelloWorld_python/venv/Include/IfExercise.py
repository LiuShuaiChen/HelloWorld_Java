
# 通过年龄判断该角色是否是未成年人
# 学习应用场景if else判断
ageStr = input("请输入你的年龄:")

print("接收到你的输入信息,结果年龄为: ",ageStr)

age = int(ageStr);

if(age > 100 or age < 0):
    print("你输入的年龄不在正常人类范围!")
else:
    if (age <= 18):
        print("你还是个孩子!")
    elif(age > 18 and age < 50):
        print("你已经步入中年!")
    elif(age >= 50):
        print("你该准备退休了!")
    else:
        print("非法输入信息!")
