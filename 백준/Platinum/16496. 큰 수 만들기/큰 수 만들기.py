import heapq


import sys
#sys.stdin = open("src/input.txt")


class node:
    def __init__(self, num):
        self.num = num

    def __lt__(self, other):

        a = len(str(self.num))
        b = len(str(other.num))
        c1 = (self.num * (10**b) + other.num)
        c2 = (other.num * (10**a)) + self.num

        return c1 > c2

    def __str__(self):
        return str(self.num)


N = int(sys.stdin.readline())

heap = [node(i) for i in map(int, sys.stdin.readline().split())]

heapq.heapify(heap)
ans = ""
while (len(heap) > 0):
    ans += str(heapq.heappop(heap))

if (ans[0] == '0'):
    print(0)
else:
    print(ans)
