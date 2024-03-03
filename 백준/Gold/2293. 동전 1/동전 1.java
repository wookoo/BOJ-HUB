import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception{
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(stk.nextToken());
        int items[] = new int[size];
        int target = Integer.parseInt(stk.nextToken());
        int dp[] = new int[target+1];
        for(int i = 0; i < size; i++){
            items[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i = 0 ; i < size; i++){
            for(int j = items[i]; j <=target;j++ ){
                dp[j] += dp[j - items[i]];
            }
        }
        System.out.println(dp[target]);

//        System.out.println(Arrays.toString(dp[target]));



    }

}