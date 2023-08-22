import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    static boolean visited[];

    static int linkSIZE[];
    static int SIZE;


    static boolean isCan = false;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        SIZE = Integer.parseInt(stk.nextToken());
        int commands = Integer.parseInt(stk.nextToken());
        visited = new boolean[SIZE];

        for(int i = 0 ; i < SIZE; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < commands; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i = 0; i <SIZE; i++){

            dfs(i,0);
            if(isCan){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    public static void dfs(int start,int depth) {

        if (depth == 4 || isCan) {
            isCan = true;
            return;
        }
        visited[start] = true;
        ArrayList<Integer> line = graph.get(start);
        for (int i : line) {

            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[start] = false;


    }
}