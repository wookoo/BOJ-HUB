
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int E;

    static int START;
    static int GOAL;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new ArrayList<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < E; i++) { //gen Graph
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken()) - 1;
            int end = Integer.parseInt(stk.nextToken()) - 1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        for (int i = 0 ; i < V; i++){
            Collections.sort(graph.get(i));
        }

        stk = new StringTokenizer(br.readLine());
        boolean visited[] = new boolean[V];

        START = Integer.parseInt(stk.nextToken())-1;
        GOAL = Integer.parseInt(stk.nextToken())-1;


        Stack<Integer> startToGoal = bfs(visited,START, GOAL);

        int ans = startToGoal.size();

        Arrays.fill(visited,false);
        for(Integer e: startToGoal){
            visited[e] = true;
        }
        visited[START] = false;
        visited[GOAL] = false;
        Stack<Integer> goalToEnd = bfs(visited,GOAL,START);
        ans += goalToEnd.size();
        ans -=2;
        System.out.println(ans);





    }

    public static Stack<Integer> bfs(boolean visited[],int start, int end) {


        Queue<Stack<Integer>> q = new LinkedList<>();
        Stack<Integer> startStack = new Stack<>();
        q.add(startStack);
        startStack.push(start);

        while (!q.isEmpty()){

            Stack<Integer> temp = q.poll();
            int cur = temp.peek();

            if (cur == end){
                return temp;
            }
            if(!visited[cur]){
                visited[cur] = true;
                for (Integer node: graph.get(temp.peek())){
                    if(!visited[node]){
                        Stack<Integer> s = new Stack<>();
                        s.addAll(temp);
                        s.push(node);
                        q.add(s);
                    }
                }
            }


        }
        return null;


    }
}