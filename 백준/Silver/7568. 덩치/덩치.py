import sys

#sys.stdin = open("input.txt")


class Person:

    def __init__(self, weight, height, name):
        self.weight = weight
        self.height = height
        self.name = name
        self.rank = 0


    def __lt__(self, other):
        return (self.weight < other.weight and self.height < other.height)

    # def __gt__(self, other):



    # def __eq__(self,other):
    #     return (self.weight < other.weight
    #             and
    #             self.height > other.height
    #             or
    #         self.weight > other.weight and self.height < other.height)




    def __repr__(self):
        # return f"[name = {self.name}, w = {self.weight}, h = {self.height}]"
        return f"{self.rank}"


size = int(sys.stdin.readline())
k = []
for i in range(size):
    weight, height = map(int, sys.stdin.readline().split())
    k.append(Person(weight, height, i))


# arr= list(sorted(k,reverse=True))
# print("=")
# print(arr)
# for i in arr:
#     print(i)
# arr[0].rank = 1
# before = arr[0]
# rank = 1
# people = 0
for i in range(size):
    now = k[i]
    rank = 1
    for j in range(size):
        other = k[j]
        if(i == j):
            continue
        if(  now.weight < other.weight and now.height < other.height   ):
            rank +=1
    now.rank = rank

print(*k)