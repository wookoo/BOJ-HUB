import sys
#sys.stdin = open("input.txt")
size = int(input())
seat = input()

seat = seat.replace("S","*S*")
seat = seat.replace("LL","*LL*")
seat = seat.replace("**","*")
result = len(seat)-size
if(result > size):
    result = size
print(result)