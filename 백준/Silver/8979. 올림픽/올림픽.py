import sys

#sys.stdin = open("input.txt")
country,target = map(int,input().split())

arr = [list(map(int,input().split())) for i in range(country)]
arr = sorted(arr,key=lambda x:(x[1],x[2],x[3]),reverse=True)
rank = 1
temp = arr[0][1:]
t = 0
for i in arr:
    j = i[1:]
   # print(temp,j)
    #print(temp!=j)

    if(temp == j):
        t +=1
    else:
        rank +=t
        t = 0
   # temp = j

    if(i[0]==target):#
        print(rank)
        break