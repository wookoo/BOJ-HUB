import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
     //   System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int arr[] =new int[size+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= size; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int dp[] = new int[size+1];
        Arrays.fill(dp,1);
        for(int i = 1; i <= size; i++){
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
        Stack s = new Stack();

        for(int i = dp.length-1; i >= 0; i--){
            if(dp[i] == result){
                result --;
                s.push(arr[i]);
            }
        }
        while (!s.empty()){
            System.out.print(s.pop()+" ");
        }
    }
}