import sys

#sys.stdin = open("input.txt")
target = int(sys.stdin.readline())
ans = 0
search = 666
while target != ans:
    if(str(search).find("666") != -1):
        # print(search)
        ans +=1
    search +=1

print(search-1)