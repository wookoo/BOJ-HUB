import java.util.*;
class Solution {

   public static int N;
    public static int M;
    public static int[][] map;
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};
    public static int ans = -1;
    public static boolean[][] visited;

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        map = maps;
        visited = new boolean[N][M];
        bfs();
        return ans;
    }
    public static void bfs(){

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int depth = arr[2];
            if(x == N-1 && y == M-1){
                ans = depth;
                return ;
            }
            if(!visited[x][y]){
                visited[x][y] =true;
                for(int i = 0 ; i <4; i++){
                    int tx = x+dx[i];
                    int ty = y+dy[i];
                    if(0<= tx && tx < N && 0<= ty && ty < M && map[tx][ty] == 1 && !visited[tx][ty]){
                        q.add(new int[]{x+dx[i],y+dy[i],depth+1});
                    }
                }
            }

        }
    }
}