import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int WIDTH;
    static int HEIGHT;
    static int TIME;
    static int GRID[][];
    static int AIR_FILTER_X;
    static int AIR_FILTER_Y;

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        TIME = Integer.parseInt(stk.nextToken());
        GRID = new int[WIDTH][HEIGHT];

        for (int i = 0; i < WIDTH; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
                if (GRID[i][j] == -1) {
                    AIR_FILTER_X = i;
                    AIR_FILTER_Y = j;
                }
            }
        }
        AIR_FILTER_X -= 1;


        for (int i = 0; i < TIME; i++) {

            spread();
            windHead();
            windTail();
//            print();
//            break;

        }
        int s = 2;
        for(int i =0 ; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT ; j++){
                s+= GRID[i][j];
            }

        }
        System.out.println(s);


    }

    public static void windHead() {
        //첫번째
        int x1 = AIR_FILTER_X;
        int y1 = HEIGHT-1;


        GRID[AIR_FILTER_X][AIR_FILTER_Y] = 0;

        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i  < HEIGHT; i++){
            dq.add(GRID[x1][i]);
        }
        for(int i = AIR_FILTER_X-1; i > 0; i--){
            dq.add(GRID[i][HEIGHT-1]);
        }
        for(int i = HEIGHT-1; i > 0; i--){
            dq.add(GRID[0][i]);
        }
        for (int i = 0 ; i <= x1; i++){
            dq.add(GRID[i][0]);
        }


        dq.addFirst(dq.pollLast());


        for(int i = 0; i  < HEIGHT; i++){
           GRID[x1][i] = dq.pollFirst();
        }
        for(int i = AIR_FILTER_X-1; i > 0; i--){
            GRID[i][HEIGHT-1] = dq.pollFirst();
        }
        for(int i = HEIGHT-1; i > 0; i--){
           GRID[0][i] = dq.pollFirst();
        }
        for (int i = 0 ; i <= x1; i++){
            GRID[i][0] = dq.pollFirst();
        }







        GRID[AIR_FILTER_X][AIR_FILTER_Y] = -1;
    }

    public static void windTail() {
        //첫번째

        int x1 = AIR_FILTER_X+1;


        GRID[x1][AIR_FILTER_Y] = 0;

        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i  < HEIGHT; i++){
            dq.add(GRID[x1][i]);
        }
        for(int i = 1; i <  WIDTH - x1; i++){
            dq.add(GRID[x1+i][HEIGHT-1]);
        }

        for(int i = HEIGHT-2; i > 0; i--){
            dq.add(GRID[WIDTH-1][i]);
        }

        for(int i = 0; i <  WIDTH - x1-1; i++){
            dq.add(GRID[WIDTH-1-i][0]);
        }





        dq.addFirst(dq.pollLast());
        for(int i = 0; i  < HEIGHT; i++){
            GRID[x1][i] = dq.pollFirst();
        }
        for(int i = 1; i <  WIDTH - x1; i++){
            GRID[x1+i][HEIGHT-1] = dq.pollFirst();
        }

        for(int i = HEIGHT-2; i > 0; i--){
           GRID[WIDTH-1][i] = dq.pollFirst();
        }

        for(int i = 0; i <  WIDTH - x1-1; i++){
            GRID[WIDTH-1-i][0] = dq.pollFirst();
        }

        GRID[x1][AIR_FILTER_Y] = -1;


    }

    public static void print() {
        for (int i = 0; i < WIDTH; i++) {
            System.out.println(Arrays.toString(GRID[i]));
        }
    }

    public static void spread() {

        int tempGrid[][] = new int[WIDTH][HEIGHT];
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (GRID[i][j] >= 5) {
                    int spreadData = GRID[i][j] / 5;
                    for (int index = 0; index < 4; index++) {
                        int tx = i + dx[index];
                        int ty = j + dy[index];
                        if (0 <= tx && tx < WIDTH &&
                                0 <= ty && ty < HEIGHT && GRID[tx][ty] != -1
                        ) {
                            //퍼져나가
                            tempGrid[tx][ty] += spreadData;
                            GRID[i][j] -= spreadData;
                        }
                    }

                }
                tempGrid[i][j] += GRID[i][j];

            }
        }
        for (int i = 0; i < WIDTH; i++) {
            GRID[i] = tempGrid[i];
        }

    }

}