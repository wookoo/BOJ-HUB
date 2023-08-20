import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    static int WIDTH;
    static int HEIGHT;

    static int GRID[][] = new int[8][8];

    static int tempMap[][] = new int[8][8];




    static int MAX = Integer.MIN_VALUE;
    static int dx[] = { 0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        GRID = new int[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        genMap(0);
        System.out.println(MAX);
    }

    public static void dfs(int x, int y) {
        tempMap[x][y] = 2;
        for(int i = 0; i < 4; i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if ( 0 <= tx && tx < WIDTH && 0<= ty && ty < HEIGHT
                && tempMap[tx][ty] == 0
            ){
                dfs(tx,ty);
            }
        }

    }

    public static void genMap(int wall) {
        if (wall == 3) {

            for (int i = 0; i < WIDTH; i++) {
                if (HEIGHT >= 0) System.arraycopy(GRID[i], 0, tempMap[i], 0, HEIGHT);
            }

            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    if(tempMap[i][j] == 2){
                        dfs(i,j);
                    }
                }
            }
            int cnt  = 0;
            for(int i = 0; i < WIDTH; i++){
                for(int j = 0; j < HEIGHT; j++){
                    if(tempMap[i][j] == 0){
                        cnt ++;
                    }
                }
            }
            MAX = Math.max(MAX,cnt);


            return;
        }
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (GRID[i][j] == 0) {
                    GRID[i][j] = 1;
                    genMap(wall + 1);
                    GRID[i][j] = 0;
                }
            }
        }
    }

}