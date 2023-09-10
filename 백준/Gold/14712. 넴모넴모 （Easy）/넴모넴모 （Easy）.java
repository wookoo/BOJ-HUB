import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean map[][] = null;
    static int WIDTH;
    static int HEIGHT;
    static int ans = 0;

    public static void main(String[] args) throws  Exception{
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        map = new boolean[WIDTH][HEIGHT];

        dfs(0,0);
        System.out.println(ans);




    }

    public static void dfs(int x, int y){
        if(x == WIDTH-1 && y== HEIGHT){
            ans++;
            return;
        }
        if(y==HEIGHT){
            x++;
            y=0;
        }
        map[x][y] = true;

        int dx[] = {-1,0,-1};
        int dy[] = {0,-1,-1};
        int cnt = 0;
        for(int index = 0; index < 3; index++){
            int nx = x+dx[index];
            int ny = y+dy[index];
            if(0 <= nx && nx < WIDTH && 0<= ny && ny < HEIGHT && map[nx][ny]){
                cnt ++;
            }
        }
        if(cnt !=3){
            dfs(x,y+1);
        }
        map[x][y] = false;
        dfs(x,y+1);


    }
}