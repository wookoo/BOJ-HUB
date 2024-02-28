import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int WIDTH;
    static char GRAPH[][];

    static int HEIGHT;
    static int WALL;
    static int COST[][][];

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void main(String[] args) throws  Exception{
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        WALL = Integer.parseInt(stk.nextToken())+1;
        GRAPH = new char[WIDTH][];
        COST = new int[WIDTH][HEIGHT][WALL];
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                Arrays.fill(COST[i][j],-1);
            }
        }
        for(int i = 0; i < WIDTH;i++){
            char line[] = br.readLine().toCharArray();
            GRAPH[i] = line;
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
                    if(GRAPH[tx][ty] == '1'){
                        if(broke < WALL-1 && COST[tx][ty][broke+1] == -1){
                            COST[tx][ty][broke+1] = COST[x][y][broke] +1;
                            q.add(new int[]{tx,ty,broke+1});
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
        for(int i = 0 ; i < WALL; i++){
            if(COST[WIDTH-1][HEIGHT-1][i] != -1){
                ans = Math.min(ans, COST[WIDTH-1][HEIGHT-1][i]);
            }
        }
        if (ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);

    }

}