import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
        //무게와 가치
        //최대 가치는?
        int itemSize = Integer.parseInt(stk.nextToken());
        int maxWeight = Integer.parseInt(stk.nextToken());

        ArrayList<int[]> item = new ArrayList<>();
        item.add(new int[]{0,0});
        for (int t = 1; t <= itemSize; t++) {
            stk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int cnt = Integer.parseInt(stk.nextToken());

            for(int i = 1; cnt> 0; i <<= 1){
                int ix = Math.min(i, cnt);
                item.add(new int[]{w * ix, v * ix});
                cnt -= ix;
            }

        }
        int dp[][] = new int[item.size() + 1][maxWeight + 1];
        dp[0][maxWeight] = -1;

        int loop = item.size()-1;
        int ans = 0;
        for(int i = 1 ; i <=  loop; i++) {
            int line[] = item.get(i);
            int w = line[0];
            int v = line[1];
            for(int k = 0; k <= maxWeight; k++){
                dp[i][k] = Math.max(dp[i-1][k],dp[i][k]);
                if(k -w >=0){
                    dp[i][k] = Math.max( dp[i-1][k-w] + v ,dp[i][k]);
                }
                ans = Math.max(dp[i][k],ans);

            }

        }
        //5면
        //1 ,2 ,4

//        System.out.println(dp[loop][maxWeight]);
        System.out.println(ans);
//        for(int i = 0; i<=loop; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }


    }


}
