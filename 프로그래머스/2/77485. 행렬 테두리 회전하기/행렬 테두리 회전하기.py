from collections import deque
def solution(rows, columns, queries):
    answer = []
    grid= [[] for i in range(rows)]
    index = 0
    for i in range(rows):
        for j in range(columns):
            index +=1
            grid[i].append(index)
         
    for x1,y1,x2,y2 in queries:
        # down v 
        q = deque([])
        for i in range(x1-1,x2):
            q.append(grid[i][y1-1])
            
        for i in range(y1,y2):
            q.append(grid[x2-1][i])
        for i in range(x2-2,x1-1,-1):
            q.append(grid[i][y2-1])
        for i in range(y2-1,y1-1,-1):
            q.append(grid[x1-1][i])
        
        temp = q.popleft()
        q.append(temp)
        answer.append(min(q))
        for i in range(x1-1,x2):
            grid[i][y1-1] = q.popleft()
            
        for i in range(y1,y2):
            grid[x2-1][i] = q.popleft()
        for i in range(x2-2,x1-1,-1):
            grid[i][y2-1] =  q.popleft()
        for i in range(y2-1,y1-1,-1):
            grid[x1-1][i] = q.popleft()
    
    # for i in grid:
    #     print(i)

    return answer