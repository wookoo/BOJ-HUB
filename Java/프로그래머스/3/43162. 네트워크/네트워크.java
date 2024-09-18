import java.util.*;
class Solution {
    
    public static int[][] GRAPH;
    public static int N;
    public int solution(int n, int[][] computers) {
        GRAPH = computers;
        N = n;
        
        return bfs();
    }
    
    public int bfs(){
        Queue<Integer> que = new LinkedList<>();
        
        boolean visited[] = new boolean[N];
        Arrays.fill(visited,false);
        que.add(0);
        int task = 0;
        do{
            task ++;
            while(!que.isEmpty()){
                int target = que.poll();
                if(!visited[target]){
                    visited[target] = true;

                    for(int i = 0 ; i < N; i++){
                        if(GRAPH[target][i] == 1){
                            que.add(i);
                        }
                    }

                }
            }
            for(int i =0; i < N; i++){
                if(!visited[i]){
                    que.add(i);
                    break;
                }
            }
    
        }while(!que.isEmpty());
        
        return task;
        

        
    }
}