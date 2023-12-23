import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        int size = Integer.parseInt(br.readLine());
        for(int i = 0;i < size; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){

                pq.add(Integer.parseInt(stk.nextToken()));
            }
        }
        for(int i = 0; i < size-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}