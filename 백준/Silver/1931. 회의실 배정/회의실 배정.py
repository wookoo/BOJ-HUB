import sys
size = int(sys.stdin.readline())
time = sorted([list(map(int,sys.stdin.readline().split())) for i in range(size)],key = lambda x: [x[1],x[0]])
end = -1
result = 0
for i in range(size):
    if (time[i][0] == time[i][1] or end <= time[i][0]):
        end = time[i][1]
        result +=1

print(result)