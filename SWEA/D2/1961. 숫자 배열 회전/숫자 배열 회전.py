def col_up(arr,index,N):
    temp = map(str,[ arr[i][index] for i in range(N-1,-1,-1)])
    return "".join(temp)
def row_reverse(arr,index,N):
    return("".join((map(str,reversed(arr[N-index-1])))))

def col_down(arr,index,N):
    temp = map(str,[ arr[i][N-index-1] for i in range(N)])
    return "".join(temp)
CASE = int(input())
for T in range(CASE):
    N = int(input())
    arr = [list(map(int,input().split())) for i in range(N)]
    print(f"#{T+1}")
    for i in range(N):
        print(col_up(arr,i,N),end=" ")
        print(row_reverse(arr,i,N),end=" ")
        print(col_down(arr,i,N))
