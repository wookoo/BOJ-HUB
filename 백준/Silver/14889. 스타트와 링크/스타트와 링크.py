from itertools import combinations
import sys
#sys.stdin = open("input.txt")


size = int(input())
grid = [list(map(int,input().split())) for i in range(size)]

arr = list(range(size))
temp = list(combinations(arr,size//2))
combinationsSize= len(temp)
minDiff = 1000000000000
fChoice =None
sChoice = None
for i in range(combinationsSize//2):
    first = temp[i]
    second = set(arr)-set(first)
    fSum = 0
    for i in first:
        for j in first:
            fSum+= grid[i][j]

    sSum = 0
    for i in second:
        for j in second:
            sSum+= grid[i][j]

    dif = abs(fSum-sSum)
    if(minDiff > dif):
        minDiff = dif

print(minDiff)

