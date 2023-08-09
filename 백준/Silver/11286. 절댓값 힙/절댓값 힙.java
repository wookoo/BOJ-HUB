import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new InputStreamReader(System.in));//, null));
       // System.setIn(new FileInputStream("input.txt"));// , null));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// , 0)
        
      
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(size, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if(Math.abs(o1)== Math.abs(o2)){
                    if(o1>o2){
                        return 1;
                    }
                    return -1;
                }
               
                return Integer.compare(Math.abs(o1),Math.abs(o2));
            }
            
        });
        for (int i = 0; i < size; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                int t = 0;
                if(!heap.isEmpty()){
                    t = heap.poll();
                }
                System.out.println(t);
                

            } else {
                heap.offer(cmd);
            }
        }
    }

}
