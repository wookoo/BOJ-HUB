import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int cost[] = new int[100001];
    public static void main(String[] args) throws Exception{

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int coin = Integer.parseInt(br.readLine());
        //2원과 5원으로만 나눠주기
        cost[0] = 0;
        cost[1] = -1;
        cost[2] = 1;
        cost[3] = -1;
        cost[4] = 2;
        cost[5] = 1;
        cost[6] = 3;
        cost[7] = 2;
        for(int i = 6; i <= coin; i++){
            int first = cost[i-2];
            int second = cost[i-5];
            if(first == -1 && second == -1){
                cost[i] = -1;
            }
            else if(first == -1){
                cost[i] = cost[i-5] +1;

            }
            else if(second == -1){
                cost[i] = cost[i-2] +1;
            }
            else{
                cost[i] = Math.min(cost[i-2] +1,cost[i-5] +1);
            }
        }
        System.out.println((cost[coin]));
    }
}