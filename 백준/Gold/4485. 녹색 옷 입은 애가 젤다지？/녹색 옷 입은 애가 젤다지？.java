import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 9999999;

    static class Node implements Comparable<Node> {
        int index, w;

        public Node(int x, int w) {
            this.index = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + index +
                    ", w=" + w +
                    '}';
        }
    }

    static int WEIGHT[][] = new int[126][126];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = 1;

        int tc = 0;
        while (true) {

            V = Integer.parseInt(br.readLine());
            if (V == 0) {
                return;
            }
            ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
            for (int i = 0; i <= V * V; i++) {
                adjList.add(new ArrayList<>());
            }
            for(int i = 0 ; i < V; i++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < V; j++){
                    WEIGHT[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            for(int i = 0 ; i < V ; i++){
                for(int j = 0 ; j < V ; j++){
                    for(int index = 0; index < 4; index ++ ){
                        int tx = i+dx[index];
                        int ty = j+dy[index];
                        if(0 <= tx && tx < V && 0<=ty && ty < V){
                            int W = WEIGHT[tx][ty];
                            adjList.get(i*V +j).add(new Node(tx*V+ty,W));
                        }
                    }
                }
            }

            int result = Dijkstra(V*V,0,adjList) + WEIGHT[0][0];
            System.out.println("Problem "+ (++tc) +": "+result);


        }
    }


    public static int Dijkstra(int n, int start, ArrayList<ArrayList<Node>> Graph) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index의 연결된 정점 비교
            for(Node next : Graph.get(nowVertex)) {
                if(dist[next.index] > dist[nowVertex]+ next.w) {
                    dist[next.index] = dist[nowVertex] + next.w;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[n-1];
    }

}
