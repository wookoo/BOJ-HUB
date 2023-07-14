import sys
#sys.stdin = open("input.txt")
N,M = map(int,input().split())
first = [input() for i in range(N)]
target = [input() for i in range(M)]
choice = [0] * M

class Node:
    def __init__(self,key,data=None):
        self.key = key
        self.data = data
        self.child = {}


class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self,string):
        temp = self.head
        for char in string:
            if char not in temp.child:
                temp.child[char] = Node(char)
            temp = temp.child[char]
        temp.data =string

    def search(self,string):
        temp = self.head
        for char in string:
            if(char in temp.child):
                temp = temp.child[char]
            else:
                return False
        return True

head = Trie()
for line in first:
    head.insert(line)

cnt = 0
for line in target:
    if(head.search(line)):
        cnt +=1
print(cnt)