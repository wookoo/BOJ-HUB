import sys
from collections import deque
#sys.stdin = open("src/input.txt")

N, K = map(int, sys.stdin.readline().split())
if (N >= K):
    print(0)
    exit(0)

remain = {}
arr = deque(map(int, input().split()))
plug = {}

for k in range(K):

    i = arr[k]
    if not i in remain:
        remain[i] = [k]
        plug[i] = False
    else:
        remain[i].append(k)

t = 0

while t < N:

    if (len(arr) == 0):
        print(0)
        exit(0)
    target = arr.popleft()
    if (not plug[target]):
        t += 1
        plug[target] = True
    del remain[target][0]


ans = 0
while len(arr) > 0:
    target = arr.popleft()

    if (plug[target]):
        del remain[target][0]
        continue

    ans += 1

    # plug의 key 가 True 면서 미래에 뽑힐게 최소값

    unplug = 0
    tempLast = -1
    for key, val in plug.items():
        if (val):
            if len(remain[key]) == 0:
                unplug = key
                break

            if (tempLast < remain[key][0]):
                unplug = key
                tempLast = remain[key][0]
    plug[target] = True
    plug[unplug] = False

    del remain[target][0]
print(ans)
