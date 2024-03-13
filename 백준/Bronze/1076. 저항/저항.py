import sys
#sys.stdin = open("input.txt")

# a,b = map(int,sys.stdin.readline().split())
# arr = [list(sys.stdin.readline().strip()) for i in range(a)]
# for i in range(a):
#     for j in range(b):
#         if(arr[i][j] == 'c'):
#             arr[i][j] = 0
#         else:
#             arr[i][j] = -1

a = {
    "black" :0,
    "brown"	:1,
    "red": 2,
    "orange":	3	,
    "yellow":	4	,
    "green"	:5	,
    "blue"	:6	,
    "violet":	7	,
    "grey":	8	,
    "white":9	,
}
first = sys.stdin.readline().strip()
second = sys.stdin.readline().strip()
third = sys.stdin.readline().strip()
print(  (a[first]*10 + a[second])*(10**a[third]) )
