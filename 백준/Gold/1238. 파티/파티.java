import javax.management.AttributeList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{

        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stk.nextToken());
        int EDGES = Integer.parseInt(stk.nextToken());
        int END = Integer.parseInt(stk.nextToken())-1;

        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        for(int i = 0; i < V; i ++){
            map.add(new ArrayList<>());
        }

        for(int i = 0 ; i < EDGES; i++){
            stk = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            map.get(S-1).add(new Node(e-1,w));
        }
        int COST[] = new int[V];

        for(int i = 0 ; i < V; i++){
            int WEIGHT[] = new int[V];
            Arrays.fill(WEIGHT,Integer.MAX_VALUE);
            WEIGHT[i]= 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            boolean visited[] = new boolean[V];
            while (!pq.isEmpty()){
                int nowV = pq.poll().end;
                if(visited[nowV]){
                    continue;
                }
                visited[nowV] = true;
                for(Node next : map.get(nowV)){
                    if(WEIGHT[next.end] > WEIGHT[nowV]+ next.weight &&  WEIGHT[nowV]+ next.weight >= 0) {
                        WEIGHT[next.end] = WEIGHT[nowV] + next.weight;

                        pq.offer(new Node(next.end, WEIGHT[next.end]));
                    }
                }
            }
            COST[i] += WEIGHT[END];
            if(i == END){
                for(int j = 0 ; j< V; j++){
                    COST[j] += WEIGHT[j];
                }
            }

        }
        System.out.println(Arrays.stream(COST).max().getAsInt());


    }
}