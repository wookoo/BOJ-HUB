import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static int SIZE;
    public static int[][] GRID;
    public static boolean[][] VISITED;
    public static int CNT=0;
    public static int[] dx ={1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static int CHECK = 0;
    public static void main(String[] args) throws Exception {
        // System.setIn(new InputStreamReader(System.in));//, null));
     //   System.setIn(new FileInputStream("input.txt"));// , null));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// , 0)
        
      
        SIZE = Integer.parseInt(br.readLine());
        GRID = new int[SIZE][SIZE];
        VISITED = new boolean[SIZE][SIZE];
        for(int i = 0 ; i < SIZE; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < SIZE; j++){
                GRID[i][j] = line[j] -'0';
            }
        }
        int cnt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < SIZE; i++){
            for(int j = 0 ; j < SIZE; j++){
                CHECK =0;
                if(VISITED[i][j] == false && GRID[i][j] == 1){
                    dfs(i, j);
                    cnt ++;
                    result.add(CHECK);
                }
                
            }
        }
        System.out.println(cnt);
        result.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1, o2);
            }
            
        });
        for (int i: result){
            System.out.println(i);
        }
        
        
    }

    public static void dfs(int x, int y){
        boolean check = (0<=x && x < SIZE && 0<= y && y <SIZE && VISITED[x][y]== false && GRID[x][y]==1);
        if(!check){
            return;
        }
        VISITED[x][y] = true;
        CHECK ++;
        
        for(int i = 0 ;i<4;i++){
            dfs(x+dx[i], y+dy[i]);
        }
        
    }
    

}
