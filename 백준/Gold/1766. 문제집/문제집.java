import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

       // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(stk.nextToken());
        int links = Integer.parseInt(stk.nextToken());
        int inOrder[] = new int[size];
        boolean visited[] = new boolean[size];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < size; i++){
            graph.add(new ArrayList<>());
        }
        //start end
        for(int i = 0 ; i < links; i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken())-1;
            int end = Integer.parseInt(stk.nextToken())-1;
            graph.get(start).add(end);
            inOrder[end] ++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < size; i++){
            if(inOrder[i] == 0 ){
                pq.add(i);
            }
        }
        while (!pq.isEmpty()){
            int node = pq.poll();
            if(!visited[node]){
                visited[node] = true;
                ArrayList<Integer> edge = graph.get(node);
                System.out.print(node+1 + " ");
                for(int n : edge){
                    inOrder[n] -=1;
                    if(inOrder[n] == 0 && !visited[n]){
                        pq.add(n);
                    }
                }
            }
        }




    }
}