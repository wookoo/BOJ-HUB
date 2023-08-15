import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[][] GRID = new int[16][16];
    static int SIZE;

    static final int VERTICAL = 0;
    static final int HORIZON = 1;
    static final int DIAGONAL = 2;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        dfs(0,0,0,1,HORIZON);
        System.out.println(ans);
    }

    public static void dfs(int x1, int y1, int x2, int y2, int direction) {

        if(x1 == SIZE-1 && y1 ==SIZE -1 || x2 == SIZE-1 && y2 ==SIZE-1){
            ans++;
            return;
        }

        if(direction == HORIZON){
            //가로 밀기, 대각밀기
            if(isValid(x2,y2+1) && isValid(x1,y1+1)){//가로밀기
                dfs(x1,y1+1,x2,y2+1,HORIZON);
            }
            if(isValid(x1,y1+1) && isValid(x2,y2+1) && isValid(x2+1,y2+1) &&isValid(x2+1,y2)      ){//대각밀기
                dfs(x1,y1+1,x2+1,y2+1,DIAGONAL);
            }


        }
        else if(direction == VERTICAL){
            if(isValid(x2+1,y2) && isValid(x1+1,y1)      ){//세로밀기
                dfs(x1+1,y1,x2+1,y2,VERTICAL);
            }
            if(isValid(x1+1,y1)&& isValid(x2+1,y2) && isValid(x2+1,y2+1) && isValid(x2,y2+1)         ){//대각밀기
                dfs(x1+1,y1,x2+1,y2+1,DIAGONAL);
            }

            //세로 밀기, 대각밀기
        }
        else{
            //가로밀기 대각밀기 세로밀기
            //가로 밀기

            if(isValid(x2,y2+1) ) {
                dfs(x1+1,y1+1,x2,y2+1,HORIZON);
            }
            if(isValid(x2+1,y2) ) { //세로밀기
                dfs(x1+1,y1+1,x2+1,y2,VERTICAL);
            }
            if(isValid(x2,y2+1) && isValid(x2+1,y2+1) &&isValid(x2+1,y2)){//대각밀기
                dfs(x1+1,y1+1,x2+1,y2+1,DIAGONAL);
            }


        }


    }
    public static boolean isValid(int x,int y){
        return 0<= x && x < SIZE && 0<=y && y<SIZE && GRID[x][y] ==0;
    }


}