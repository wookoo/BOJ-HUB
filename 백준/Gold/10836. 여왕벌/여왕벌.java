import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int GRID[][];
    static int UPGRADE[][];

    static int upSize[];

    static int M;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        int DAY = Integer.parseInt(stk.nextToken());
        GRID = new int[M][M];
        UPGRADE = new int[M][M];
        upSize = new int[2 * M - 1];
        for (int qwer = 0; qwer < DAY; qwer++) {

            stk = new StringTokenizer(br.readLine());
            int zeroCnt = Integer.parseInt(stk.nextToken());
            int oneCnt = Integer.parseInt(stk.nextToken());
            int twoCnt = Integer.parseInt(stk.nextToken());
            int index = zeroCnt;
            for (int i = 0; i < oneCnt; i++) {
                upSize[index++] += 1;
            }
            for (int i = 0; i < twoCnt; i++) {
                upSize[index++] += 2;
            }
//            setUPGRADE(zeroCnt,oneCnt,twoCnt);

//            System.out.println(Arrays.toString(upSize));


        }
        setUPGRADE();
        calcUpgrade();
        printBoard();


    }

    public static void printBoard() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(UPGRADE[i][j] + 1 + " ");
            }
            System.out.println();
        }
    }

    public static void writeBoard() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(UPGRADE[i][j] + 1 + " ");
            }
            System.out.println();
        }
    }

    public static void setUPGRADE(int zeroCnt, int oneCnt,int twoCnt){
        int x = M;
        int y = 0;
        int dx = -1;
        int dy = 0;
        for(int i = 0 ; i < zeroCnt; i++){
            if(x+dx == -1){
                dx =0;
                dy = 1;
            }
            x +=dx;
            y += dy;
            UPGRADE[x][y] += 0;
        }
        for(int i = 0 ; i < oneCnt; i++){
            if(x+dx == -1){
                dx =0;
                dy = 1;
            }
            x +=dx;
            y += dy;
            UPGRADE[x][y]+= 1;
        }
        for(int i = 0 ; i < twoCnt; i++){
            if(x+dx == -1){
                dx =0;
                dy = 1;
            }
            x +=dx;
            y += dy;
            UPGRADE[x][y] += 2;
        }

        for(int i = 0 ; i < M; i++){
            System.out.println(Arrays.toString(UPGRADE[i]));
        }
        System.out.println("===");

    }

    public static void setUPGRADE() {
        int x = M;
        int y = 0;
        int dx = -1;
        int dy = 0;

        int index = 0;
        for(int i = 0 ; i < 2*M -1; i++){
            if (x + dx == -1) {
                dx = 0;
                dy = 1;
            }
            x += dx;
            y += dy;
            UPGRADE[x][y] += upSize[index++];
        }
//
//        for(int i = 0 ; i < M; i++){
//            System.out.println(Arrays.toString(UPGRADE[i]));
//        }
//        System.out.println("===");

    }

    public static void calcUpgrade() {
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                int up = UPGRADE[i][j - 1];
                int left = UPGRADE[i - 1][j];
                int leftUp = UPGRADE[i - 1][j - 1];
                int temp = up;
                temp = Math.max(left, temp);
                temp = Math.max(leftUp, temp);
                UPGRADE[i][j] = temp;
            }
        }
    }


}
