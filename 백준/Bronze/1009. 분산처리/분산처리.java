import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // System.setIn(new InputStreamReader(System.in));//, null));
        //System.setIn(new FileInputStream("input.txt"));// , null));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// , 0)
        int size = Integer.parseInt(br.readLine());

        for(int i = 0 ;  i< size; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());//, null, false)
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            
            int result = 1;
            for(int sq = 0; sq <b; sq++){
                result = (result * a)%10;
            }
            if(result ==0){
                result = 10;
            }
            System.out.println(result);

        }
     
        
    }

    

}
