import sys
#sys.stdin = open("input.txt")
N,M,L = map(int,input().split())
#M = target
people = [0] *N
pos = 0

cnt = 0
while True:
    cnt +=1
    people[pos] +=1
    if(people[pos] == M):
        break

    elif(people[pos]%2==0):
        #짝수인경우
        pos = (pos +N -L)%N
    else:
        pos = (pos+L)%N
print(cnt-1)