import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int GRID[][] = new int[51][51];
    public static boolean VISITED[][] = new boolean[51][51];
    public static int WIDTH;
    public static int HEIGHT;

    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < tc; TC++) {
            // 10 8 17
            StringTokenizer stk = new StringTokenizer(br.readLine());// , null, false)
            for (int i = 0; i < 51; i++) {
                Arrays.fill(GRID[i], 0);
                Arrays.fill(VISITED[i], false);// TC, tc, br);
            }

            
            WIDTH = Integer.parseInt(stk.nextToken());
            HEIGHT = Integer.parseInt(stk.nextToken());
            int cnt = Integer.parseInt(stk.nextToken());

            for (int i = 0; i < cnt; i++) {
                stk = new StringTokenizer(br.readLine());// , null, false)
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                GRID[x][y] = 1;
            }

            int warm = 0;
            for(int x = 0; x < WIDTH; x++){
                for(int y=0; y <HEIGHT; y++){
                    if(VISITED[x][y]== false&&GRID[x][y] ==1){
                        dfs(x, y);
                        warm++;
                    }
                }
            }
            System.out.println(warm);

        }
        // StringTokenizer stk = new StringTokenizer(br.readLine());

    }
    public static void dfs(int x,int y){
        boolean flag = (0<= x && x < WIDTH && 0 <= y && y< HEIGHT && VISITED[x][y]== false && GRID[x][y] ==1);
        if(!flag){
            return;
        }
        VISITED[x][y] = true;
        for(int i = 0; i < 4;i++){
            dfs(x+dx[i], y+dy[i]);
        }
    }   
}