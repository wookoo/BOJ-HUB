import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("input.txt"));

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(sc.readLine());
        int SIZE = Integer.parseInt(stk.nextToken());
        int TC = Integer.parseInt(stk.nextToken());
        int grid[] = new int[SIZE];
        int dp[] = new int[SIZE];
        stk = new StringTokenizer(sc.readLine());
        int temp = 0;
        for (int i = 0; i < SIZE; i++) {
            
            
            int input = Integer.parseInt(stk.nextToken());
            grid[i] = input;
            dp[i] = temp + input;
            temp = dp[i];
        }
        //System.out.println(Arrays.toString(dp));

        for (int tc = 0; tc < TC; tc++) {
            stk = new StringTokenizer(sc.readLine());
            int x1 = Integer.parseInt(stk.nextToken()) - 1;
            int y1 = Integer.parseInt(stk.nextToken()) - 1;
      
            int result = dp[y1] - dp[x1]+grid[x1];
    

            System.out.println(result);
            // System.out.println("---");
        }
    }
}
