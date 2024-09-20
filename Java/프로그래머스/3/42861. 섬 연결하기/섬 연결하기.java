import java.util.*;
public class Solution {

    public static class Node implements Comparable<Node>{

        public int start;
        public int end;
        public int cost;

        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }


    public int solution(int n, int[][] costs) {
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] line: costs){
            int start = line[0];
            int end = line[1];
            int cost = line[2];
            Node node= new Node(start, end, cost);
            Node node2 = new Node(end,start,cost);
            graph.get(start).add(node);
            graph.get(end).add(node2);
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node node : graph.get(0)){
            pq.add(node);
        }
        visited[0]=true;
        int ans = 0;
        while (!pq.isEmpty()){
            Node node = pq.poll();

            if(!visited[node.end]){
                visited[node.end]=true;
                ans += node.cost;
                for(Node node1 : graph.get(node.end)){
                    pq.add(node1);
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4,new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));

    }


}