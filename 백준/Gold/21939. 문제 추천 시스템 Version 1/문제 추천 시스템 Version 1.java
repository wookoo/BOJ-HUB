import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {



        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questions = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0],o2[0]);
                }
                return Integer.compare(o1[1],o2[1]);
            }
        });

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o2[0],o1[0]);
                }
                return Integer.compare(o2[1],o1[1]);
            }
        });
        HashMap<Integer,Boolean> solved = new HashMap<>();
        HashMap<Integer,Integer> cost = new HashMap<>();

        for(int i = 0 ; i < questions ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(stk.nextToken());
            int hard = Integer.parseInt(stk.nextToken());
            int arr[] = new int[]{number,hard};
            minHeap.add(arr);
            maxHeap.add(arr);
            solved.put(number,false);
            cost.put(number,hard);
        }
        int actions = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < actions; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String action = stk.nextToken();
            if(action.equals("add")){
                int number = Integer.parseInt(stk.nextToken());
                int hard = Integer.parseInt(stk.nextToken());
                int arr[] = new int[]{number,hard};
                minHeap.add(arr);
                maxHeap.add(arr);
                cost.put(number,hard);
                solved.put(number,false);

            }
            else if(action.equals("solved")){

                int number = Integer.parseInt(stk.nextToken());

                solved.put(number,true);

            }
            else { //recommend
                PriorityQueue<int[]> heap = Integer.parseInt(stk.nextToken()) == -1 ? minHeap : maxHeap;
                while (solved.get(heap.peek()[0]) || cost.get(heap.peek()[0]) != heap.peek()[1]){
                    heap.poll();
                }
                //peek 할때 cost 가 같은지 다른지 검사하기
                int arr[] = heap.peek();
                System.out.println(arr[0]);
            }

        }








    }
}