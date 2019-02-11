import time

# 求和递归
# 例如 参数为5 返回结果是(5+4+3+2+1)

sum = 0;

def sumRecursion(num):
    # start = time.time();
    if(num > 1):
        sum = num + sumRecursion(num - 1);
    else:
        sum = 1;
    # end = time.time();
    # times = (int)(end - start);
    # print("运行了", times ,"ms");
    return sum;

print(sumRecursion(10000))