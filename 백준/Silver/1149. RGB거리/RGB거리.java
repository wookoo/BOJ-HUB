import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int run = Integer.parseInt(br.readLine());
        int[][] dp = new int[run][3];
        int[][] arr = new int[run][3];

        for (int i = 0; i < run; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < run; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        int minCost = Math.min(Math.min(dp[run - 1][0], dp[run - 1][1]), dp[run - 1][2]);
        System.out.println(minCost);
    }
}
