import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int WIDTH;
    static int GRAPH[][];

    static int HEIGHT;
    static int COST[][][];

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void main(String[] args) throws  Exception{
     //   System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        GRAPH = new int[WIDTH][HEIGHT];
        COST = new int[WIDTH][HEIGHT][2];
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                for(int k = 0; k < 2; k++){
                    COST[i][j][k] = -1;
                }
            }
        }
        for(int i = 0; i < WIDTH;i++){
            char line[] = br.readLine().toCharArray();
            for(int j = 0; j < HEIGHT; j++){
                GRAPH[i][j] = line[j] - '0';
            }
        }

        COST[0][0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        while (!q.isEmpty()){
            int[] line = q.poll();
            int x = line[0];
            int y = line[1];
            int broke = line[2];
            for(int index = 0; index < 4; index++){
                int tx = x+dx[index];
                int ty = y+dy[index];
                if(0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT && COST[tx][ty][broke] == -1){
                    if(GRAPH[tx][ty] == 1){
                        if(broke == 0){
                            COST[tx][ty][1] = COST[x][y][0] +1;
                            q.add(new int[]{tx,ty,1});
                        }
                    }
                    else{
                        COST[tx][ty][broke] = COST[x][y][broke] + 1;
                        q.add(new int[]{tx,ty,broke});
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        if(COST[WIDTH-1][HEIGHT-1][0] != -1){
            ans = Math.min(ans, COST[WIDTH-1][HEIGHT-1][0]);
        }
        if(COST[WIDTH-1][HEIGHT-1][1] != -1){
            ans = Math.min(ans, COST[WIDTH-1][HEIGHT-1][1]);
        }
        if (ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);

    }

}