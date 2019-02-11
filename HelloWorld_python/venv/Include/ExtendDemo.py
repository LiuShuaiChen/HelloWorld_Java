# 关于数组的增删改查


# import numpy as np
# np.set_printoptions(threshold = 1e6)

a=[2,3,4];

b=["a","d","s","f"];

name = input("请输入要查询的关键字:")

a.extend(b);
print(a);

# 关键字查找Demo
#设置flag 0表示没有找到 1表示找到
findFlag = 0;

for i in a:
    if (name == i):
        findFlag = 1;
        break;
    else:
        findFlag = 0;

if findFlag == 1:
    print("关键字"+name+"存在,该关键字的下标为%s" %(a.index(name)));
else:
    print("关键字" + name + "不存在");


a.remove("s");
print(a);

del a[1];
print(a);

a.pop();
print(a);

a.insert(2,"apple");
print(a);

a.append("ibm");
print(a);

a.append(b);
print(a)

# b.extend(a);
c=['1','2','3','4','5','6','7','8','9','aasss',['11','22','33','44','55','66','77']];

for d in c:
    # print(d,end=".");
    for f in d:
        print(f,end=",");
print()

print(len(c));


