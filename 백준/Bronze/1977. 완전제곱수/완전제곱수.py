import sys
#sys.stdin = open("input.txt")
import math
start = int(input())
end = int(input())
fStart = int(math.sqrt(start))
fEnd = int(math.sqrt(end))+1
s = -1
arr = []
for i in range(fStart,fEnd):
    if( start <= i*i <= end):
        arr.append(i*i)
if arr:
    print(sum(arr))
    print(min(arr))
else:
    print(-1)