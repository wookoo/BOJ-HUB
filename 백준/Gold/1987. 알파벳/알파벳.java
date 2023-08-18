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

    static int GRID[][] = null;

    static int VISITED = 0;

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    static int max = -1;

    //D then +1 % 4;
    //L then +3 % 4

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        GRID = new int[WIDTH][HEIGHT];
        for(int i = 0 ; i < WIDTH; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < HEIGHT; j++){
                GRID[i][j] = line[j] - 'A';
            }
        }

        dfs(0,0,1);
        System.out.println(max);
    }
    public static void dfs(int x,int y,int depth){

        max = Math.max(max,depth);

        VISITED |= (1 << GRID[x][y]);

//        System.out.print( (char)(GRID[x][y] +'A'));
        for(int index = 0; index < 4; index ++){
            int tx = x + dx[index];
            int ty = y + dy[index];
            if (0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT && ((VISITED >> GRID[tx][ty]) & 1) == 0) {

                dfs(tx, ty, depth + 1);

            }
        }
        VISITED &= ~(1 << GRID[x][y]);



    }

}