import sys
#sys.stdin = open("input.txt")

#white Black
arr = [list(sys.stdin.readline().strip()) for i in range(8)]
#print(arr)
for i,char in enumerate(arr):
    if(i%2 ==1):

        arr[i].pop(0)
        arr[i].append(".")


ans = 0
for i in arr:
    for index,j in enumerate(i):
        if(index%2==0 and j =='F'):
            ans +=1
print(ans)