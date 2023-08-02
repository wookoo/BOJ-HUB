import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(sc.readLine());
        int SIZE = Integer.parseInt(stk.nextToken());
        int TC = Integer.parseInt(stk.nextToken());
        int dp[][] = new int[SIZE+1][SIZE+1];
        for (int i = 1; i <= SIZE; i++) {
            stk = new StringTokenizer(sc.readLine()); 
            int temp = 0;
            for (int j = 1; j <= SIZE; j++) {
                int input = Integer.parseInt(stk.nextToken());
                dp[i][j] = temp + input;
                temp = dp[i][j];

            }
        }


        for (int tc = 0; tc < TC; tc++) {
            stk = new StringTokenizer(sc.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            int result = 0;
            for (int i = x1; i <= x2; i++) {
                result += dp[i][y2] - dp[i][y1-1];
            }
      
			bw.append(String.valueOf(result));
			bw.newLine();;
      
            // System.out.println("---");
        }
		bw.flush();
    }
}
