import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int asd = 0 ; asd < tc; asd ++){
            int size = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int ans = (int)(size/2.0 + 0.5);
            System.out.println(ans);
            int printCnt = 0;
            for(int i = 1 ; i <= size; i++){
                if(!stk.hasMoreElements()){
                    stk = new StringTokenizer(br.readLine());
                }
                int num = Integer.parseInt(stk.nextToken());
                pq.add(num);
                if(i%2 == 1){
                    int shouldOut = (int)(i/2.0 + 0.5);
                    List<Integer> temp = new ArrayList<>();
                    for(int j = 0 ; j< shouldOut-1; j++){
                        temp.add(pq.poll());
                    }
                    printCnt +=1;
                    System.out.print(pq.peek()+ " ");
                    if(printCnt %10 == 0){
                        System.out.println();
                    }
                    pq.addAll(temp);
                }


            }
            System.out.println();
        }


    }


}
