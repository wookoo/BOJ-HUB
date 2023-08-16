import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {
    static int GRID[][] = new int[50][50];
    static boolean onCloud[][] = new boolean[50][50];
    static int SIZE;
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};


    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int EDGES[] = {1, 3, 5, 7};
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
        plusDY = new int[]{SIZE, SIZE, 0, 0, 0, 0, 0, SIZE}; //8방 탐색이므로 증가되는경우, 감소되는경우가 있음 그경우 인덱스 제한을 위한 값
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
            for (int x = 0; x < SIZE; x++) {
                Arrays.fill(onCloud[x], false);
            }
            needUp.clear(); //초기화 끝


            for (int move = 0; move < moves; move++) { //구름 이동
                for (int[] arr : CLOUDS) {
                    int x = arr[0];
                    int y = arr[1];

                    arr[0] = (x + dx[direction] + plusDX[direction]) % SIZE; //dx 가 음수가 나와버리면 SIZE 를 더해주게 구현이 되어있음
                    arr[1] = (y + dy[direction] + plusDY[direction]) % SIZE;

                }
            }
            for (int[] arr : CLOUDS) { //이동이 끝나서 구름이 있는 위치 갱신
                int x = arr[0];
                int y = arr[1];
                GRID[x][y] += 1; //비 추가
                onCloud[x][y] = true;
            }
            //여기서 CLOUDS CHECK;
            for (int[] arr : CLOUDS) {
                int x = arr[0];
                int y = arr[1];
                int up = 0;
                for (int index = 0; index < 4; index++) {
                    int tx = x + dx[EDGES[index]];
                    int ty = y + dy[EDGES[index]];
                    if (0 <= tx && tx < SIZE && 0 <= ty && ty < SIZE && GRID[tx][ty] > 0) { //대각선 물 몇개?
                        up++;
                    }
                }
                needUp.add(new int[]{x, y, up});

            }
            for (int[] arr : needUp) { //대각선 구름 만큼 증가
                int x = arr[0];
                int y = arr[1];
                int up = arr[2];
                GRID[x][y] += up;
            }

            CLOUDS.clear();
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < SIZE; y++) {
                    if (GRID[x][y] >= 2 && !onCloud[x][y]) {
                        GRID[x][y] -= 2;
                        CLOUDS.add(new int[]{x, y});
                    }
                }
            }


        }
        int cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cnt += GRID[i][j];
            }
        }
        System.out.println(cnt);


    }
}
