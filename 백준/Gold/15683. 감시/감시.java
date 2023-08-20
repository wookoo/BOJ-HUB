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

    static int dx_1[] = {0,1,-1,0};
    static int dy_1[] = {1,0,0,-1};

    static int dx_2[][] = {{0,1,0,-1},{0,-1,0,1}};
    static int dy_2[][] = {{1,0,-1,0},{-1,0,1,0}};

    static int dx_3[][] = {{0,1,0,-1},{1,0,-1,0}};
    static int dy_3[][] =  {{1,0,-1,0},{0,-1,0,1}};


    static int dx_4[][] = {{0,1,0,-1},{0,-1,0,1},{1,0,-1,0} };
    static int dy_4[][] = {{1,0,-1,0},{-1,0,1,0},{0,1,0,-1} };
    static int dx_5[][] = {{0,1,0,-1} };
    static int dy_5[][] = {{1,0,-1,0} };



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
        for(int i = 0 ; i < WIDTH; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < HEIGHT; j++){
                GRID[i][j] = Integer.parseInt(stk.nextToken());
                if(GRID[i][j] == 0){
                    MIN ++;
                }
                else if(GRID[i][j] != 0 && GRID[i][j] != 6){
                    POSITION.add(new int[]{i,j,GRID[i][j]});
                }
            }
        }
        MAX_DEPTH = POSITION.size();

//        System.out.println(MAX_DEPTH);
        dfs(0);
        System.out.println(MIN);

    }
    public static void dfs(int depth){
        if(depth == MAX_DEPTH){
            int cnt = 0;
            for(int i = 0; i < WIDTH; i++){
                for(int j = 0; j < HEIGHT; j++){
//                    System.out.print(GRID[i][j] +" ");
                    if(GRID[i][j] == DEAD){
                        cnt ++;
                    }
                }
//                System.out.println();
            }
//            System.out.println("\n\n");
            MIN = Math.min(MIN,cnt);
            return;
        }

        int now[] = POSITION.get(depth);
        int x = now[0];
        int y = now[1];
        int direction = now[2];
        List<int[]> changed = new ArrayList<>();

        if(direction  == 1){
            for(int i = 0; i < 4; i++){
                int dx = dx_1[i];
                int dy = dy_1[i];

                int tx = x + dx;
                int ty = y + dy;
                while(0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&
                        GRID[tx][ty] != 6
                ){
                    if(GRID[tx][ty] == DEAD){
                        changed.add(new int[]{tx,ty});
                        GRID[tx][ty] = WATCH;
                    }
                    tx += dx;
                    ty += dy;
                }
                dfs(depth +1);
                for (int[] arr : changed){
                    GRID[arr[0]][arr[1]] = DEAD;
                }
            }
        }
        else if(direction == 2){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    int dx = dx_2[j][i];
                    int dy = dy_2[j][i];
                    int tx = x + dx;
                    int ty = y + dy;
                    while(0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&
                            GRID[tx][ty] != 6
                    ){
                        if(GRID[tx][ty] == DEAD){
                            changed.add(new int[]{tx,ty});
                            GRID[tx][ty] = WATCH;
                        }
                        tx += dx;
                        ty += dy;
                    }
                }

                dfs(depth +1);
                for (int[] arr : changed){
                    GRID[arr[0]][arr[1]] = DEAD;
                }
            }
        }


        else if(direction == 3){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 2; j++){
                    int dx = dx_3[j][i];
                    int dy = dy_3[j][i];
                    int tx = x + dx;
                    int ty = y + dy;
                    while(0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&
                            GRID[tx][ty] != 6
                    ){
                        if(GRID[tx][ty] == DEAD){
                            changed.add(new int[]{tx,ty});
                            GRID[tx][ty] = WATCH;
                        }
                        tx += dx;
                        ty += dy;
                    }
                }


                dfs(depth +1);
                for (int[] arr : changed){
                    GRID[arr[0]][arr[1]] = DEAD;
                }
            }
        }

        else if(direction == 4){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 3; j++){
                    int dx = dx_4[j][i];
                    int dy = dy_4[j][i];
                    int tx = x + dx;
                    int ty = y + dy;
                    while(0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&
                            GRID[tx][ty] != 6
                    ){
                        if(GRID[tx][ty] == DEAD){
                            changed.add(new int[]{tx,ty});
                            GRID[tx][ty] = WATCH;
                        }
                        tx += dx;
                        ty += dy;
                    }
                }


                dfs(depth +1);
                for (int[] arr : changed){
                    GRID[arr[0]][arr[1]] = DEAD;
                }
            }
        }
        else if(direction == 5){
            for(int i = 0; i < 1; i++){
                for(int j = 0; j < 4; j++){
                    int dx = dx_5[i][j];
                    int dy = dy_5[i][j];
                    int tx = x + dx;
                    int ty = y + dy;
                    while(0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&
                            GRID[tx][ty] != 6
                    ){
                        if(GRID[tx][ty] == DEAD){
                            changed.add(new int[]{tx,ty});
                            GRID[tx][ty] = WATCH;
                        }
                        tx += dx;
                        ty += dy;
                    }
                }

                dfs(depth +1);
                for (int[] arr : changed){
                    GRID[arr[0]][arr[1]] = DEAD;
                }
            }
        }



    }






}