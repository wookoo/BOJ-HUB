import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int arr[] = new int[1048576]; //8이면.. 목 = 1 나머지 0
        while(stk.hasMoreTokens()){
            int now = Integer.parseInt(stk.nextToken());
            int x = now/32;
            int y = now%32;
            int temp = arr[x]>>y;
            if( (temp&1) == 0){
                int k = 1 << y;
                arr[x] |= k;
                bw.write(now + " ");
            }
        }
        bw.flush();

    }


}