import sys
#sys.stdin = open("input.txt")
class Country:
    def __init__(self,arr):
        self.name = arr[0]
        self.gold = arr[1]
        self.silver = arr[2]
        self.bronze = arr[3]

    def __lt__(self, other):
        if(self.gold == other.gold):
            if(self.silver == other.silver):
                return self.bronze > other.bronze
            return self.silver > other.silver
        return self.gold > other.gold
    def __eq__(self, other):
        return  self.gold == other.gold and self.silver == other.silver and self.bronze == other.bronze

    def __repr__(self):
        return  f"name = {self.name},gold = {self.gold},silver = {self.silver}, bronze = {self.bronze}"


SIZE,TARGET = map(int,sys.stdin.readline().split())
countrys = []
top = {}
for i in range(SIZE):
    line = list(map(int,sys.stdin.readline().split()))
    c = Country(line)
    top[line[0]] = c
    countrys.append(c)
countrys = sorted(countrys)
start = countrys[0]
win = 1
start.win = 1
upCnt = 0
del countrys[0]
for i in countrys:
    upCnt +=1
    if(start != i):
        win +=upCnt
        start = i
        upCnt = 0
    i.win = win

print((top[TARGET].win))