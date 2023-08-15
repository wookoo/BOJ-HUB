import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
    static int GRID[][] = new int[300][300];
    static  boolean VISITED[][] = new boolean[300][300];
    static int WIDTH;
    static int HEIGHT;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};

    static ArrayList<int[]> decrease = new ArrayList<>();


    public static void main(String[] args) throws Exception {
          //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());


        for (int i = 0; i < WIDTH; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int year = -1;
        while (true){  //시작
            year ++;
            for(int i = 0; i < WIDTH; i++){ //방문 초기화
                Arrays.fill(VISITED[i],false);
            }
            int cnt = 0;
            for(int i = 0; i <WIDTH; i++){
                for(int j = 0; j< HEIGHT; j++){
                    if(GRID[i][j] > 0 && !VISITED[i][j]){ //방문되지 않은 상태고 빙산이면 dfs 수행
                        cnt ++;
                        dfs(i,j);

                    }
                }
            }
//            System.out.println("Cnt " + cnt);
            if(cnt >=2) { //dfs 를 46번 라인에서 2번이상 수행했으면

                System.out.println(year);
                break;

            }
            if(cnt == 0){ //쪼개지지 않았으면
                System.out.println(0);
                break;
            }


            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {

                    if (GRID[i][j] > 0) { //빙산이면
                        int up = 0;//감소할 숫자
                        for (int index = 0; index < 4; index++) { //상하좌우 탐색
                            int tx = i + dx[index];
                            int ty = j + dy[index];
                            if (0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT && GRID[tx][ty] == 0){
                                up++; //주변이 바다면 감소수 1증가
                            }
                        }
                        if(up > 0){ //감소한다면
                            decrease.add(new int[]{i,j,up}); //값 추가
                        }

                    }
                }
            }
            for(int[] arr:decrease){ //감소할 빙산들을 업데이트
                int x = arr[0];
                int y = arr[1];
                int up = arr[2];
                GRID[x][y] -= up;
                if(GRID[x][y] < 0){
                    GRID[x][y] = 0;
                }
            }
            decrease.clear();
        }

    }

    static void dfs(int x, int y){
        boolean check = (0<=x && x < WIDTH && 0<= y && y <HEIGHT && !VISITED[x][y] && GRID[x][y]>0);
        if(!check){
            return;
        }
        VISITED[x][y] = true;
        for(int i = 0 ;i<4;i++){
            dfs(x+dx[i], y+dy[i]);
        }
    }

}