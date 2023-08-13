import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class COLOR {
    public static final String RESET = "\u001B[0m";
    public static final String FONT_BLACK = "\u001B[30m";
    public static final String FONT_RED = "\u001B[31m";
    public static final String FONT_GREEN = "\u001B[32m";
    public static final String FONT_YELLOW = "\u001B[33m";
    public static final String FONT_BLUE = "\u001B[34m";
    public static final String FONT_PURPLE = "\u001B[35m";
    public static final String FONT_CYAN = "\u001B[36m";
    public static final String FONT_WHITE = "\u001B[37m";

    static void printGreen(int o) {
        System.out.print(FONT_GREEN + o + " " + RESET);
    }

    static void printWhite(int o) {
        System.out.print(o + " " + RESET);
    }

}

public class Main {
    static int GRID[][] = new int[50][50];
    static boolean onCloud[][] = new boolean[50][50];
    static int SIZE;
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};


    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int EDGES[]  = {1,3,5,7};
    static int plusDX[];
    static int plusDY[];
    static int INDEX = 0;

    static ArrayList<int[]> CLOUDS = new ArrayList<int[]>();

    static ArrayList<int[]> needUp = new ArrayList<int[]>();

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        SIZE = Integer.parseInt(stk.nextToken());
        plusDY = new int[]{SIZE, SIZE, 0, 0, 0, 0, 0, SIZE};
        plusDX = new int[]{0, SIZE, SIZE, SIZE, 0, 0, 0, 0};

        int CMD = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < SIZE; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        CLOUDS.add(new int[]{SIZE - 1, 0});
        CLOUDS.add(new int[]{SIZE - 1, 1});
        CLOUDS.add(new int[]{SIZE - 2, 0});
        CLOUDS.add(new int[]{SIZE - 2, 1});
//        print();

        for (int i = 0; i < CMD; i++) {
            stk = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(stk.nextToken()) - 1;
            int moves = Integer.parseInt(stk.nextToken());
            for(int x =0; x<SIZE; x++){
                Arrays.fill(onCloud[x],false);
            }
            needUp.clear(); //초기화 끝


            for (int move = 0; move < moves; move++) {
                for (int[] arr : CLOUDS) {
                    int x = arr[0];
                    int y = arr[1];

                    arr[0] = (x+ dx[direction] + plusDX[direction]) % SIZE;
                    arr[1] = (y+dy[direction] + plusDY[direction])%SIZE;

                }
            }
            for (int[] arr : CLOUDS) {
                int x = arr[0];
                int y = arr[1];
                GRID[x][y] +=1;
                onCloud[x][y] = true;
            }
            //여기서 CLOUDS CHECK;
            for (int[] arr : CLOUDS) {
                int x = arr[0];
                int y = arr[1];
                int up = 0;
                for(int index = 0; index < 4; index++){
                    int tx = x + dx[EDGES[index]];
                    int ty = y + dy[EDGES[index]];
                    if(0 <= tx && tx <SIZE && 0<=ty && ty<SIZE&& GRID[tx][ty] >0){
                        up ++;
                    }
                }
                needUp.add(new int[]{x,y,up});

            }
            for(int[] arr: needUp){
                int x = arr[0];
                int y = arr[1];
                int up = arr[2];
                GRID[x][y] += up;
            }

            CLOUDS.clear();
            for(int x = 0; x <SIZE; x++){
                for(int y = 0; y < SIZE; y++){
                    if(GRID[x][y] >=2 && !onCloud[x][y]){
                        GRID[x][y] -=2;
                        CLOUDS.add(new int[]{x,y});
                    }
                }
            }



        }
        int cnt = 0;
        for(int i =0; i <SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                cnt += GRID[i][j];
            }
        }
        System.out.println(cnt);


    }

    static void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boolean flag = false;
                for (int[] arr : CLOUDS) {
                    if (arr[0] == i && arr[1] == j) {
                        COLOR.printGreen(GRID[i][j]);
                        flag = true;
                        break;
                    }

                }
                if (!flag) {
                    COLOR.printWhite(GRID[i][j]);
                }

            }
            System.out.println();
        }

    }
}