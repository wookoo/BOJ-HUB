
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        // Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 0; tc < 10; tc++) {
            sc.readLine();
            int grid[][] = new int[100][100];
            int tX = 0;
            int tY = 0;
            for(int i = 0 ; i <100;i++){
                StringTokenizer stk = new StringTokenizer(sc.readLine());
                for(int j = 0; j<100;j++){
                    grid[i][j] = Integer.parseInt(stk.nextToken());
                    if(grid[i][j] == 2){
                        tX = i;
                        tY = j;
                    }
                }
            }
            int move =0;
            int dx[] = {0,0,-1};
            int dy[] = {-1,1,0};
            while(tX > 0){
                //in Bound Check
                //leftCheck
                grid[tX][tY]= 2;
                for(int i  = 0; i < 3; i++){
                    int nx = tX+dx[i];
                    int ny = tY+dy[i];
                    if(0<= ny && ny<100 && grid[nx][ny] == 1 ){
                        tX = nx;
                        tY = ny;
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc+1,tY);
            
        
    
             
           
            
            
            

          
        }

    }
}
