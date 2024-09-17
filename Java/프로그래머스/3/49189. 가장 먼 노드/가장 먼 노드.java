import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int cost[] = new int[n];
        boolean visited[] = new boolean[n];
        visited[0] = true;
        cost[0] = 0;

        // pd [index,cost]
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            if (x == 0) {
                cost[y] = 1;
            }
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i : graph.get(0)) {
            q.add(new int[]{i, 1});
        }
        while (!q.isEmpty()) {
            int item[] = q.poll();
            int node = item[0];
            int c = item[1];
            if (!visited[node]) {
                visited[node] = true;
                cost[node] = c;
                for (int next : graph.get(node)) {
                    q.add(new int[]{next, c + 1});
                }
            }
        }
        int max = Arrays.stream(cost).max().getAsInt();
        int ans = 0;
        for(int i : cost){
            if(max == i){
                ans +=1;
            }
        }
        return ans;

    }
}