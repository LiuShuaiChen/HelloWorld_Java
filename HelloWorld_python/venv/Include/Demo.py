import random

print("猜拳游戏1:石头2:剪刀3:布")
player = input("请猜拳:")
play = int(player)
computer = random.randint(1, 3)
# 玩家计数
playcount = 0
# 电脑计数
computercount = 0
# 玩的次数
count = 0
while playcount <= 2 or computercount <= 2:
    if (play >= 1 and play <= 3):
        print(play)
        print(computer)
        if play > computer:
            print("玩家赢")
            playcount += 1
            count += 1
            if playcount >= 2:
                print("玩家胜出")
                break
            if count < 3:
                player = input("请猜拳:")
                play = int(player)
                computer = random.randint(1, 3)
        elif computer > play:
            print("电脑赢")
            computercount += 1
            count += 1
            if computercount >= 2:
                print("电脑胜出")
                break
            if count < 3:
                player = input("请猜拳:")
                play = int(player)
                computer = random.randint(1, 3)
        else:
            count += 1
            print("平局")
            if count < 3:
                player = input("请猜拳:")
                play = int(player)
                computer = random.randint(1, 3)
    else:
        print("输入值非法,请输入有效值")
