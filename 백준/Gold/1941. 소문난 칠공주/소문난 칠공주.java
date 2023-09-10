import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int temp_graph[][] = new int[5][5];

    static char graph[][] = new char[5][];
    static int ans = 0;

    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            graph[i] = br.readLine().toCharArray();
        }
        boolean visited[] = new boolean[25];
        combination(visited, 0, 25, 7);
        System.out.println(ans);
    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < 5; i++) {
                Arrays.fill(temp_graph[i], 0);
            }
            int startX = 0;
            int startY = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
//                    System.out.print(i + " ");
                    int x = i / 5;
                    int y = i % 5;
                    startX = x;
                    startY = y;
                    temp_graph[x][y] = 1;
                }
            }
            int dx[] = {0,1,0,-1};
            int dy[] = {1,0,-1,0};
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startX,startY});
            int depth = 0;
            int S = 0;
            int Y = 0;
            while(!q.isEmpty()){
                int[] line = q.poll();
                int nx = line[0];
                int ny = line[1];
                if(temp_graph[nx][ny] ==1){
                    depth ++;
                    if(graph[nx][ny] == 'Y'){
                        Y++;
                    }
                    else{
                        S++;
                    }
                    temp_graph[nx][ny] = 99;
                    for(int index=0; index < 4;index++){
                        int tx = nx+dx[index];
                        int ty = ny+dy[index];
                        if(0 <= tx && tx < 5 && 0 <= ty && ty < 5 && temp_graph[tx][ty] ==1){
                            q.add(new int[]{tx,ty});
                        }
                    }
                }
            }
            if(depth == 7){
                if(S>=4){
                    ans++;
                }
            }


            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}