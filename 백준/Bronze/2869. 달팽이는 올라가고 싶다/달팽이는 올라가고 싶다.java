import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(stk.nextToken());
        int down = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());
        target = target - up;
        if(target <= 0){
            System.out.println(1);
            return;
        }
        up = up - down;

        System.out.println( (int)Math.ceil((double) target/up)+ 1);


    }


}
