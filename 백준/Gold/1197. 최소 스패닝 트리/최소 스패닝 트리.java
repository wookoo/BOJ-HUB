import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Edge implements Comparable<Edge> {

    int to;
    long weight;

    public Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
    }
}

public class Main {

    static boolean[] VISITED = null;

    public static void main(String[] args) throws Exception {

       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int TC = Integer.parseInt(br.readLine());

        int TC = 1;
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(stk.nextToken());
            int edges = Integer.parseInt(stk.nextToken());

            VISITED = new boolean[nodes];

            ArrayList<ArrayList<Edge>> arr = new ArrayList<ArrayList<Edge>>();

            for (int i = 0; i < nodes; i++) {
                arr.add(new ArrayList<Edge>());
            }
            for (int i = 0; i < edges; i++) {

                stk = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(stk.nextToken()) - 1;
                int end = Integer.parseInt(stk.nextToken()) - 1;
                long w = Long.parseLong(stk.nextToken());
                arr.get(start).add(new Edge(end, w));
                arr.get(end).add(new Edge(start, w));
            }
            PriorityQueue<Edge> q = new PriorityQueue<Edge>();
            q.add(new Edge(0,0));
            long ans = 0;
            while(!q.isEmpty()){
                Edge e = q.poll();
                int v = e.to;
                long w = e.weight;
                if(!VISITED[v]){
                    VISITED[v] = true;
                    ans += w;
                    for(Edge ed: arr.get(v)){
                        if(!VISITED[ed.to]){
                            q.add(ed);
                        }
                    }
                }
            }
            System.out.println(ans);

        }
    }

}