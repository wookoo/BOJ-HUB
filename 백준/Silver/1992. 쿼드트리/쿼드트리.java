import java.io.*;
import java.util.*;

public class Main {




    static int SIZE;
    static int[][] GRID = new int[64][64];
    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < SIZE; i++){
            char [] line = br.readLine().toCharArray();
            for(int j = 0; j < SIZE; j++){
                GRID[i][j] = line[j] - '0';
            }
        }
        dfs(0,0,SIZE);
//        System.out.println(check(0,2,2));

    }
    public static void dfs(int x, int y, int size){
        if(check(x,y,size)) {
            System.out.print(GRID[x][y]);
            return;
        }
        else{
            int tempSize = size/2;
            System.out.print("(");
            dfs(x,y,tempSize);
            dfs(x,y+tempSize,tempSize);
            dfs(x+tempSize,y,tempSize);
            dfs(x+tempSize,y+tempSize,tempSize);
            System.out.print(")");


        }
    }
    public static boolean check(int x, int y, int size){
        int target = GRID[x][y];
        for(int i = 0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                if(target != GRID[x+i][y+j]){
                    return  false;
                }
            }
        }

        return  true;
    }
}
