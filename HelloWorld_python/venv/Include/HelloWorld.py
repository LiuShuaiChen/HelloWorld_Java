# -*- coding: UTF-8 -*-


print("HelloWorld");
print("你好,世界!");
print(1+2);
print(2==3);
print(1-0.3);
if(3==3):
    print(2+2);
elif(3!=4):
    print("3!=4");
else:
    print(4+3);

print("="*5);

print(' '.join([''.join([('AndyLove'[(x-y)%8]if((x*0.05)**2+(y*0.1)**2-1)**3-(x*0.05)**2*(y*0.1)**3<=0 else' ')for x in range(-30,30)])for y in range(15,-15,-1)]));

print(''.join(__import__('random').choice('\u2571\u2572') for i in range(50*24)));

print('\n'.join([''.join([('AndyLove!'[(x-y)%7]if((x*0.05)**2+(y*0.1)**2-1)**3-(x*0.05)**2*(y*0.1)**3<=0 else' ')for x in range(-30,30)])for y in range(15,-15,-1)]))