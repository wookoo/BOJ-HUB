import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int WHITE = 1;
    static int BLACK = 0;
    static long BW = 0b10101010;
    static long WB = 0b01010101;
    static long grid[];


    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(stk.nextToken());
        int H = Integer.parseInt(stk.nextToken());
        grid = new long[W];

        for (int i = 0; i < W; i++) {
            char line[] = br.readLine().toCharArray();
            long t = 0;
            for(int j = 0 ; j < H; j++){
                char temp = line[j];
                if(temp == 'W'){
                    t = (t << 1) | 1;
                }
                else{
                    t = t<<1;
                }
            }
            grid[i] = t;
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < W - 7; i++) {
            for (int j = 0; j < H -7; j++) {
                int first = checkBW(i, j);
                ans = Math.min(first,ans);
                int second = checkWB(i,j);
                ans = Math.min(second,ans);

            }
        }
        System.out.println(ans);


    }

    public static int checkBW(int x, int y) {
        long result[] = new long[8];
        for(int i = x ; i < x+8; i++){
            long now = grid[i] >>y;
            now = now & 0b11111111;
            result[i-x] = now;
        }


        long board[] = {
                BW, WB, BW, WB, BW, WB, BW, WB
        };
        int ans = 0;
        for(int i=0; i < 8; i++){
            long now = result[i];
            long b = board[i];
            ans += Long.bitCount(now^b);
        }
        return ans;
    }

    public static int checkWB(int x, int y) {

        long board[] = {
                WB, BW, WB, BW, WB, BW, WB, BW
        };

        long result[] = new long[8];
        for(int i = x ; i < x+8; i++){
            long now = grid[i] >>>y;
            now = now & 0b11111111;
            result[i-x] = now;
        }

        int ans = 0;
        for(int i=0; i < 8; i++){
            long now = result[i];
            long b = board[i];
            ans += Long.bitCount(now^b);
        }
        return ans;
    }


}