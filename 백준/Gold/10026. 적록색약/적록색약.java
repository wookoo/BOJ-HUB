import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {
    static int SIZE;

    static char GRID[][] = new char[100][];

    static boolean VISITED[][] = new boolean[100][100];

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static HashMap<Character,Character> convertor = new HashMap<>();







    //적 녹 색약
    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        convertor.put('R','R');
        convertor.put('G','R');
        convertor.put('B','B');

        SIZE = Integer.parseInt(br.readLine());

        for(int s = 0; s <SIZE; s++){
            GRID[s] = br.readLine().toCharArray();

        }

        int cnt = 0 ;
        for(int i = 0 ; i < SIZE; i++){
            for(int j = 0 ; j < SIZE; j++){
                if(!VISITED[i][j]){
                    dfs(i,j,GRID[i][j]);
                    cnt ++;
                }
            }
        }
        System.out.print(cnt+" ");

        for(int i = 0 ; i < SIZE; i++){
            Arrays.fill(VISITED[i],false);
        }

        cnt = 0;
        for(int i = 0 ; i < SIZE; i++){
            for(int j = 0 ; j < SIZE; j++){
                if(!VISITED[i][j]){
                    dfs2(i,j,convertor.get(GRID[i][j]));
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);

    }

    public static void dfs(int x, int y,char TARGET){
        for(int i = 0 ; i < 4; i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if(0 <= tx  && tx < SIZE
                && 0 <= ty && ty < SIZE
                    && !VISITED[tx][ty] && GRID[tx][ty] == TARGET
            ){
                VISITED[tx][ty] =true;
                dfs(tx,ty,TARGET);

            }
        }

    }

    public static void dfs2(int x, int y,char TARGET){
        for(int i = 0 ; i < 4; i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if(0 <= tx  && tx < SIZE
                    && 0 <= ty && ty < SIZE
                    && !VISITED[tx][ty] && convertor.get(GRID[tx][ty]) == TARGET
            ){
                VISITED[tx][ty] =true;
                dfs2(tx,ty,TARGET);

            }
        }

    }






}