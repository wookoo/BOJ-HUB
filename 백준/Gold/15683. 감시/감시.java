import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {
    static int WIDTH;
    static int HEIGHT;

    static int GRID[][] = new int[8][8];


    static int DX[][][] = {{{0, 1, -1, 0}},
            {{0, 1}, {0, -1}},
            {{0, 1, 0, -1}, {1, 0, -1, 0}},
            {{0, 1, 0, -1}, {0, -1, 0, 1}, {1, 0, -1, 0}},
            {{0}, {1}, {0}, {-1}}
    };

    static int DY[][][] = {
            {{1, 0, 0, -1}},
            {{1, 0, -1, 0}, {-1, 0, 1, 0}},
            {{1, 0, -1, 0}, {0, -1, 0, 1}},
            {{1, 0, -1, 0}, {-1, 0, 1, 0}, {0, 1, 0, -1}},
            {{1}, {0}, {-1}, {0}}
    };


    static final int WATCH = 9;
    static final int DEAD = 0;


    static List<int[]> POSITION = new ArrayList<>();


    static int MIN = 0;

    static int MAX_DEPTH;


    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < WIDTH; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
                if (GRID[i][j] == 0) {
                    MIN++;
                } else if (GRID[i][j] != 0 && GRID[i][j] != 6) {
                    POSITION.add(new int[]{i, j, GRID[i][j]});
                }
            }
        }
        MAX_DEPTH = POSITION.size();
        dfs(0);
        System.out.println(MIN);

    }

    public static void dfs(int depth) {
        if (depth == MAX_DEPTH) {
            int cnt = 0;
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
//                    System.out.print(GRID[i][j] +" ");
                    if (GRID[i][j] == DEAD) {
                        cnt++;
                    }
                }
//                System.out.println();
            }
//            System.out.println("\n\n");
            MIN = Math.min(MIN, cnt);
            return;
        }

        int now[] = POSITION.get(depth);
        int x = now[0];
        int y = now[1];
        int direction = now[2]-1;
        List<int[]> changed = new ArrayList<>();
        int[][] dxs =DX[direction];
        int[][] dys =DY[direction];
//        System.out.println(dxs.length);
//        System.out.println(dxs[0].length);

        for (int i = 0; i < dxs[0].length; i++) {
            for (int j = 0; j < dxs.length; j++) {
                int dx = dxs[j][i];
                int dy = dys[j][i];
                int tx = x + dx;
                int ty = y + dy;
                while (0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&
                        GRID[tx][ty] != 6
                ) {
                    if (GRID[tx][ty] == DEAD) {
                        changed.add(new int[]{tx, ty});
                        GRID[tx][ty] = WATCH;
                    }
                    tx += dx;
                    ty += dy;
                }

            }
            dfs(depth + 1);
            for (int[] arr : changed) {
                GRID[arr[0]][arr[1]] = DEAD;
            }


        }


    }


}