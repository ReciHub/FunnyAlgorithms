import math
num=int(input())
s=0;
square=int(math.pow(num,2));
while(square):
    s=s+square/10
    square=square/10
if(s==num):
    print("it is a neon number")
else:
    print("it is not a neon number")