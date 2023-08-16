import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {

    static int GRID[][] = null;
    static int WIDTH ;
    static int HEIGHT;

    static int MAX = Integer.MIN_VALUE;

    static int dx[][] ={{0,0,0,0},{0,1,2,3},{0,0,1,1},{0,0,0,1},{0,1,2,1},{1,1,1,0},{0,1,2,1},{0,1,2,2},{0,1,2,2},{0,1,1,1},
            {0,0,0,1},{0,0,1,2},{0,0,1,2},{0,1,1,1},{0,0,0,1},{0,1,1,2},{1,1,0,0},{0,1,1,2},{0,0,1,1}
    };
    static int dy[][] = {{0,1,2,3,4},{0,0,0,0},{0,1,0,1},{0,1,2,1},{0,0,0,1},{0,1,2,1},{1,1,1,0},{0,0,0,1},{1,1,1,0},{0,0,1,2},
            {0,1,2,0},{0,1,1,1},{0,1,0,0},{2,0,1,2},{0,1,2,2},{0,0,1,1},{0,1,1,2},{1,1,0,0},{0,1,1,2}
    };


    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        GRID =new int[WIDTH][HEIGHT];
        for(int i = 0; i < WIDTH; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < HEIGHT; j++){
                GRID[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                for(int index =0; index < dx.length; index++){
                    if(isValid(i,j,index)){
                        int tempDX[] = dx[index];
                        int tempDY[] = dy[index];
                        int s =0;
                        for(int t = 0; t < 4; t++){
                            int tx = i + tempDX[t];
                            int ty = j+ tempDY[t];
                            s += GRID[tx][ty];
                        }
                        MAX = Math.max(s,MAX);
                    }

                }
            }
        }
        System.out.println(MAX);



    }

    public static boolean isValid(int x,int y, int index){
        int tempDX[] = dx[index];
        int tempDY[] = dy[index];
        for(int i = 0; i < 4; i++){
            int tx = x + tempDX[i];
            int ty = y+ tempDY[i];

            if (!(0<= tx && tx < WIDTH && 0<= ty && ty < HEIGHT)){
                return  false;
            }
        }
        return true;
    }
}
