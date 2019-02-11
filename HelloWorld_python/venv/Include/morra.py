import random

print("欢迎来到猜拳游戏")
print("游戏规则为 1石头 2剪刀 3布")

playerInput = input("请选择你要选择的猜拳")
player = int(playerInput)
computer = random.randint(1,3)

# 累计胜利次数 满足两次 直接结束游戏
playerWinCount = 0
computerWinCount = 0

while playerWinCount <= 2 or computerWinCount <= 2:
    if(player <= 3 and player >=1):
        if (player > computer):
            print("=" * 20)
            print("该局玩家赢WIN")
            print("=" * 20)
            playerWinCount+=1
            if(playerWinCount == 2):
                print("玩家赢得最终的胜利")
                break
            if playerWinCount <= 2 or computerWinCount <= 2:
                playerInput = input("请选择你要选择的猜拳")
                player = int(playerInput)
                computer = random.randint(1, 3)
        elif (player < computer):
            print("=" * 20)
            print("该局电脑赢WIN")
            print("=" * 20)
            computerWinCount+=1;
            if (computerWinCount == 2):
                print("电脑赢得最终的胜利")
                break
            if playerWinCount <= 2 or computerWinCount <= 2:
                playerInput = input("请选择你要选择的猜拳")
                player = int(playerInput)
                computer = random.randint(1, 3)
        else:
            print("=" * 20)
            print("该局平局")
            print("=" * 20)
            if playerWinCount <= 2 or computerWinCount <= 2:
                playerInput = input("请选择你要选择的猜拳")
                player = int(playerInput)
                computer = random.randint(1, 3)
    else:
        print("输入非法!")
        break
