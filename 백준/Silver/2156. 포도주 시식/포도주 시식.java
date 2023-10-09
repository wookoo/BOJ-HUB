import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[10005];
        for(int i = 0; i < size; i++){
            arr[i+3] = Integer.parseInt(br.readLine());
        }
        int dp[] = new int[10005];

        for(int i = 3; i <= size+2;i++){
            int temp = Math.max(dp[i-3] + arr[i]+arr[i-1], dp[i-2] + arr[i]);
            temp = Math.max(temp,dp[i-1]);
            dp[i] = temp;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}