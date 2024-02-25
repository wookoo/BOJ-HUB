import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static int ans = 0;
    static boolean visited[];
    static ArrayList<ArrayList<int[]>> nodes;
    static int maxS = 0;

    public static void main(String[] args) throws Exception {

        //시작점은 단말노드로부터 시작 -> 노드가 한개인것만.

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());
        nodes = new ArrayList<ArrayList<int[]>>();
        visited = new boolean[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            nodes.add(new ArrayList<int[]>());
        }
        for (int i = 0; i < nodeCnt-1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken())-1;
            int end = Integer.parseInt(stk.nextToken())-1;
            int cost = Integer.parseInt(stk.nextToken());
            nodes.get(start).add(new int[]{end,cost});
            nodes.get(end).add(new int[]{start,cost});
        }
        Arrays.fill(visited, false);
        dfs(0,0);
        ans = 0;
        Arrays.fill(visited, false);
        dfs(maxS,0);

        System.out.println(ans);
    }

    public static void dfs(int start, int cost) {
        visited[start] =true;
        if(cost > ans){
            ans = cost;
            maxS = start;
        }
        ArrayList<int[]> arr = nodes.get(start);
        for(int[] node: arr){
            int s = node[0];
            int c = node[1];
            if(visited[s]){
                continue;
            }
            dfs(s,c+cost);
        }



    }


}
