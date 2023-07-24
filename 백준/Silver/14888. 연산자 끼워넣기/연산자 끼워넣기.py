import sys

import itertools
#sys.stdin = open("input.txt", "r")
size = int(input())
arr = list(map(int,input().split()))
op = list(map(int,input().split()))
temp = []
for i in range(op[0]):
    temp.append("+")

for i in range(op[1]):
    temp.append("-")

for i in range(op[2]):
    temp.append("*")

for i in range(op[3]):
    temp.append("/")

maxResult = -10000000000
minResult = 10000000000

op = set(list(itertools.permutations(temp,len(temp))))
for i in op:
    s= arr[0]
    for index in range(len(i)):
        symbol = i[index]
        if(symbol == "+"):
            s += arr[index+1]
        elif(symbol == "-"):
             s -= arr[index+1]
        elif(symbol == "*"):
             s *= arr[index+1]
        else:
             s = int(s/arr[index+1])

    if(s > maxResult):
        maxResult = s
    if(s < minResult):
        minResult = s
print(maxResult)
print(minResult)