import sys
#sys.stdin = open("input.txt")
size,window = map(int,sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))
s = sum(arr[:window])
result = s
end = window
start = 0
for i in range(end,size):
    s = s+arr[i]-arr[start]
    start +=1
    result = max(s,result)

print(result)
