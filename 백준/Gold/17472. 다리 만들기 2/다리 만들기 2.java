
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



    static int WIDTH;
    static int HEIGHT;
    static int GRAPH[][];
    static boolean VISITED[][];

    static int ans = Integer.MAX_VALUE;

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    private static int V = 4;


    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/bj/BJ_17472.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        GRAPH = new int[WIDTH][HEIGHT];
        VISITED = new boolean[WIDTH][HEIGHT];

        for (int i = 0; i < WIDTH; i++) {

            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                GRAPH[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        ArrayList<ArrayList<int[]>> ed = new ArrayList<>();

        int depth = 1;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (GRAPH[i][j] == 1 && !VISITED[i][j]) {
                    depth++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] line = queue.poll();
                        int cx = line[0];
                        int cy = line[1];
                        if (!VISITED[cx][cy]) {
                            VISITED[cx][cy] = true;
                            GRAPH[cx][cy] = depth;
                            int direction = 0 ;
                            for (int index = 0; index < 4; index++) {
                                int nx = cx + dx[index];
                                int ny = cy + dy[index];
                                if (0 <= nx && nx < WIDTH && 0 <= ny && ny < HEIGHT ) {
                                    if(!VISITED[nx][ny] && GRAPH[nx][ny] == 1){
                                        queue.add(new int[]{nx, ny});
                                    }
                                    if(GRAPH[nx][ny] == 0){
                                        direction |= (1 << index);
                                    }
                                }
                            }
                            if(direction > 0){
                                if(ed.size() == depth-2){
                                    ed.add(new ArrayList<>());
                                }

                                ed.get(depth-2).add(new int[]{cx,cy,direction});
                            }

                        }
                    }
                }
            }
        }

        int WEIGHT[][] = new int[ed.size()][ed.size()];
        for(int i = 0 ; i < ed.size();i++){
            for(int j = 0; j < ed.size(); j++){
                WEIGHT[i][j] = Integer.MAX_VALUE;
            }
            WEIGHT[i][i] = 0;
        }


        for(int i =0; i < ed.size(); i++){
            ArrayList<int[]> first = ed.get(i);
            for(int j = i+1; j < ed.size(); j++){
                ArrayList<int[]> second = ed.get(j);
                for(int[] firstNode : first){
                    for(int[] secondNode :second){
                        int firstDirection = firstNode[2];

                        int secondDirection = secondNode[2];

                        int firstX = firstNode[0];
                        int firstY = firstNode[1];

                        int secondX = secondNode[0];
                        int secondY = secondNode[1];
                        //X == X 면 A B

                        int firstXD = firstDirection & 0b1100;
                        int secondXD = secondDirection & 0b1100;
                        int firstYD = firstDirection & 0b11;
                        int secondYD = secondDirection & 0b11;

                        //1100
                        //1000

                        boolean yFlag = (((firstXD >> 1) & secondXD) !=0) || ((secondXD >> 1) & firstXD) != 0;

                        boolean xFlag = (((firstYD >> 1) & secondYD) !=0) || ((secondYD >> 1) & firstYD) != 0;


                        if((firstX == secondX && xFlag)){

                            int abs = Math.abs(firstX - secondX) + Math.abs(firstY - secondY)-1;
                            if(abs > 1){
                                int Y = Math.max(firstY,secondY)-1;
                                while (GRAPH[firstX][Y] == 0){
                                    Y--;
                                }
                                if(Y == Math.min(firstY,secondY)){
                                    WEIGHT[i][j] = Math.min(abs,WEIGHT[i][j]);
                                    WEIGHT[j][i] = Math.min(abs,WEIGHT[j][i]);
                                }



                            }

                        }
                        else if((firstY == secondY && yFlag)){



                            //여기서 하나씩 올라가기

                            int abs = Math.abs(firstX - secondX) + Math.abs(firstY - secondY)-1;

                            if(abs > 1){
                                int X = Math.max(firstX,secondX)-1;
                                while (GRAPH[X][firstY] == 0){
                                    X--;
                                }
                                if(X == Math.min(firstX,secondX)){
                                    WEIGHT[i][j] = Math.min(abs,WEIGHT[i][j]);
                                    WEIGHT[j][i] = Math.min(abs,WEIGHT[j][i]);
                                }

                            }

                        }

                    }
                }
            }
        }


        V = ed.size();

        Graph graph2 = new Graph(V);

        for (int i = 0; i < V; i++){
            for(int j = 0 ; j < V; j++){
                if(WEIGHT[i][j] != Integer.MAX_VALUE){
                    graph2.addEdge(i,j,WEIGHT[i][j]);
                }
            }
        }
        graph2.primMST();




    }

    static class Graph {
        private int V; // 노드 수
        private List<Edge>[] adjList; // 인접 리스트

        public Graph(int V) {
            this.V = V;
            this.adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        // 간선을 추가하는 메서드
        public void addEdge(int u, int v, int weight) {
            adjList[u].add(new Edge(v, weight));
            adjList[v].add(new Edge(u, weight));
        }

        // 프림 알고리즘을 사용하여 최소 신장 트리를 구하는 메서드
        public void primMST() {
            boolean[] visited = new boolean[V]; // 노드 방문 여부를 저장하는 배열
            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight)); // 간선을 저장하는 최소 힙
            List<Edge> result = new ArrayList<>(); // 최소 신장 트리의 간선들을 저장할 리스트

            // 임의의 시작 노드를 선택
            int startNode = 0;

            // 시작 노드를 방문으로 표시
            visited[startNode] = true;

            // 시작 노드에서 출발하는 모든 간선을 최소 힙에 추가
            for (Edge edge : adjList[startNode]) {
                minHeap.offer(edge);
            }

            while (!minHeap.isEmpty()) {
                Edge edge = minHeap.poll();

                int u = edge.dest;
                int weight = edge.weight;
                if(weight == Integer.MAX_VALUE){
                    continue;
                }
                // 이미 방문한 노드인 경우 무시
                if (visited[u]) {
                    continue;
                }

                // 해당 간선을 최소 신장 트리에 추가
                result.add(edge);
                visited[u] = true;

                // 현재 노드에서 출발하는 모든 간선을 최소 힙에 추가
                for (Edge nextEdge : adjList[u]) {
                    if (!visited[nextEdge.dest]) {
                        minHeap.offer(nextEdge);
                    }
                }
            }
            for(boolean b: visited){
                if (! b){
                    System.out.println("-1");
                    return;
                }
            }

            // 최소 신장 트리의 간선 출력
            int ans = 0;
            for (Edge edge : result) {
                ans += edge.weight;
            }
            System.out.println(ans);
        }

        class Edge {
            int src, dest, weight;

            public Edge(int dest, int weight) {
                this.dest = dest;
                this.weight = weight;
            }
        }
    }








}
