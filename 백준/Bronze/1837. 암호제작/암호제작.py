import sys
#sys.stdin = open("input.txt", "r")
multed, target = map(int,input().split())
import math
finish = int(math.sqrt(multed))
if(finish >target):
    finish = target
for i in range(2,finish+1):
    if(multed%i ==0):
        break
if(i < target):
    print("BAD",i)
else:
    print("GOOD")