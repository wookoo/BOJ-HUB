import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int tc = Integer.parseInt(br.readLine());
        int COST[][] = new int[500][500];

        for(int TC =1; TC <= tc ; TC ++){


            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            for (int i  = 0; i  < N; i++){
                Arrays.fill(COST[i],Integer.MAX_VALUE);
            }

            for(int i = 0; i  < M; i++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(stk.nextToken());
                int end = Integer.parseInt(stk.nextToken());
                start-=1;
                end -=1;
                COST[start][end]=1;


            }
            for(int i = 0; i < N;i++){
                COST[i][i] = 0;
            }

            for(int k = 0; k < N; k++){
                for(int a = 0; a < N; a++){
                    for(int b = 0; b < N; b++){
                        if(COST[a][k] + COST[k][b]  < 0){
                            COST[a][b] =COST[a][b];
                        }
                        else{
                            COST[a][b] = Math.min(COST[a][b],COST[a][k] + COST[k][b]);
                        }

                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < N; i++){
                int cnt = 0;
                for(int j = 0; j< N; j++){
                    if(COST[i][j] != COST[j][i] ){
                        cnt++;
                    }
                }
                if(cnt == N-1){
                    ans ++;
                }
            }
            System.out.println("#"+TC+" "+ans);
        }
    }

}

