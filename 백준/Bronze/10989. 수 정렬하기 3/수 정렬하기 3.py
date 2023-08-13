import sys
size = int(sys.stdin.readline())
arr= [0]* (10000+1)
for i in range(size):
    data = int(sys.stdin.readline())
    arr[data] += 1
    
for index,i in enumerate(arr):
    for j in range(i):
        print(index)