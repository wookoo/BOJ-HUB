import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

      //  System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        for(int i = 1; i < target; i ++){
           int num =i;
           int divder = i;
           while(divder > 0){
               num += divder %10;
               divder /=10;
           }
//            System.out.println(num);
           if(num == target){
               System.out.println(i);
               return;
           }
        }
        System.out.println(0);


    }


}
