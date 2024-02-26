import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

       // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int drop = (int)((size*0.15) +0.5);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < size; i ++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 0 ; i < drop; i++){
            pq.poll();
        }
        int totalSize = size - drop - drop;
        int ans = 0;
        for(int i = 0 ; i < totalSize; i++){
            int temp= pq.poll();
            ans += temp;
        }

        System.out.println( (int) ((double)ans/totalSize + 0.5));


    }


}
