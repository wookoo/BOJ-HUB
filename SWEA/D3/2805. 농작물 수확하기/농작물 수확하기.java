
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
        int TC = Integer.parseInt(sc.readLine());
        for (int tc = 0; tc < TC; tc++) {

            


            int GRID_SIZE = Integer.parseInt(sc.readLine());

            int GRID[][] = new int[GRID_SIZE][GRID_SIZE];

            for (int x = 0; x < GRID_SIZE; x++) {
                char line[] = sc.readLine().toCharArray();
                int index = 0;
                for (int y = 0; y < GRID_SIZE; y++) {
                    GRID[x][y] = line[index++] - '0';
                }
               
            }
            //3
            //2 4
            //start = GRID_SIZE/2
            //end = GRID_SIZE/2
            int start = GRID_SIZE/2;
            int end = GRID_SIZE/2;
            int line = 0;
            int result = 0;
            while(0<=start){
                for(int i= start; i <=end; i++){
                   result+= GRID[line][i];
                }
                line++;
                start--;
                end++;
            }
            start = GRID_SIZE/2;
            end = GRID_SIZE/2;
            line = GRID_SIZE -1;
            while(0<start){
                for(int i= start; i <=end; i++){
                   result+= GRID[line][i];
                }
                line--;
                start--;
                end++;
            }
            System.out.printf("#%d %d\n",tc+1,result);
            
            
            

          
        }

    }
}
