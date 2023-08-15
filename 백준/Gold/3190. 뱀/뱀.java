import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    static int GRID[][] = new int[100][100];
    static int DIRECTIONS[][] = new int[100][100];
    static int SIZE;

    static final int E = 0;
    static final int S = 1;
    static final int W = 2;
    static final int N = 3;

    static final int APPLE = 1;
    static final int BODY = 2;

    static int headDirection = E;

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    static int headX = 0;
    static int headY = 0;
    static int tailX = 0;
    static int tailY = 0;

    //D then +1 % 4;
    //L then +3 % 4

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());
        int apples = Integer.parseInt(br.readLine());
        for (int i = 0; i < apples; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            GRID[Integer.parseInt(stk.nextToken()) - 1][Integer.parseInt(stk.nextToken()) - 1] = APPLE;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                DIRECTIONS[i][j] = 7;
            }
        }
        DIRECTIONS[headX][headY] = E;
        GRID[0][0] = BODY;
        headX = 0;
        headY = 0;
        tailX = 0;
        tailY = 0;


        int CMD = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < CMD; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(stk.nextToken());

            for (int j = ans; j < time; j++) {
//                printGRID();
//                System.out.println("head X Y SIZE"+ headX +", " + headY + ", " + SIZE);
//                System.out.println("TIME " + time);
                if (0 <= headX + dx[headDirection] && headX + dx[headDirection] < SIZE &&
                        0 <= headY + dy[headDirection] && headY + dy[headDirection] < SIZE &&
                        GRID[headX + dx[headDirection]][headY + dy[headDirection]] != BODY
                ) {
                    ans++;

//                    DIRECTIONS[headX + dx[headDirection]][headY + dy[headDirection]] = headDirection;
                    if (GRID[headX + dx[headDirection]][headY + dy[headDirection]] == APPLE) {

                    }
                    else{
                        int toward = DIRECTIONS[tailX][tailY];
                        GRID[tailX][tailY] = 0;
                        tailX += dx[toward];
                        tailY += dy[toward];

                    }

                    headX += dx[headDirection];
                    headY += dy[headDirection];
                    DIRECTIONS[headX][headY] = headDirection;


                    GRID[headX][headY] = BODY;
                }
                else{
                    System.out.println(ans+1);
                    return;
                }
            }
            char toward = stk.nextToken().charAt(0);
            if (toward == 'D') {
//                System.out.println(ans + ", D");
                headDirection = (headDirection + 1) % 4;
            } else {
//                System.out.println(ans + ",L");
                headDirection = (headDirection + 3) % 4;
            }
            DIRECTIONS[headX][headY] = headDirection;

        }

        while (0 <= headX + dx[headDirection] && headX + dx[headDirection] < SIZE &&
                0 <= headY + dy[headDirection] && headY + dy[headDirection] < SIZE &&
                GRID[headX + dx[headDirection]][headY + dy[headDirection]] != BODY
        ) {
            ans++;

//                    DIRECTIONS[headX + dx[headDirection]][headY + dy[headDirection]] = headDirection;
            if (GRID[headX + dx[headDirection]][headY + dy[headDirection]] == APPLE) {

            }
            else{
                int toward = DIRECTIONS[tailX][tailY];
                GRID[tailX][tailY] = 0;
                tailX += dx[toward];
                tailY += dy[toward];

            }

            headX += dx[headDirection];
            headY += dy[headDirection];
            DIRECTIONS[headX][headY] = headDirection;


            GRID[headX][headY] = BODY;
        }




        System.out.println(ans+1);


    }

    public static void printGRID() {
        final String FONT_RED = "\u001B[31m";
        final String FONT_GREEN = "\u001B[32m";
        final String RESET = " \u001B[0m";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GRID[i][j] == APPLE) {
                    System.out.print(FONT_RED + APPLE + RESET);
                } else if (GRID[i][j] == BODY) {
                    System.out.print(FONT_GREEN + BODY + RESET);
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n\n===");
    }

    public static void printDirection() {
        final String FONT_RED = "\u001B[31m";
        final String FONT_GREEN = "\u001B[32m";
        final String FONT_YELLOW = "\u001B[33m";
        final String FONT_CYAN = "\u001B[36m";
        final String RESET = " \u001B[0m";


        HashMap<Integer, Character> hs = new HashMap<>();
        hs.put(E, 'E');
        hs.put(W, 'W');
        hs.put(S, 'S');
        hs.put(N, 'N');
        System.out.println("headDirection = " + hs.get(headDirection));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (DIRECTIONS[i][j] == E) {
                    System.out.print(FONT_RED + 'E' + RESET);
                } else if (DIRECTIONS[i][j] == W) {
                    System.out.print(FONT_GREEN + 'W' + RESET);
                } else if (DIRECTIONS[i][j] == N) {
                    System.out.print(FONT_YELLOW + 'N' + RESET);
                } else if (DIRECTIONS[i][j] == S) {
                    System.out.print(FONT_CYAN + 'S' + RESET);
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n\n===");
    }

}