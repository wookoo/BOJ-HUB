import javax.management.AttributeList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());



        if(size%2==1){
            System.out.println(0);
        }
        else{
            int dp[] = new int[31];
            dp[2] = 3;
            for(int i = 4; i<=size; i+=2){
                dp[i] +=2;
                dp[i] += dp[i-2]*3;
                for(int j = 2; j<i-2; j+=2){
                    dp[i] += dp[j]*2;

                }
            }
            System.out.println((dp[size]));
        }


    }
}