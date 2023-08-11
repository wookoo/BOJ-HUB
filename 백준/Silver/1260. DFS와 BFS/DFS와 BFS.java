import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static boolean graph[][] = new boolean[1001][1001];
	static boolean visited[] = new boolean[1001];
	static int SIZE;


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		SIZE = Integer.parseInt(stk.nextToken());
		int edges = Integer.parseInt(stk.nextToken());
		int start = Integer.parseInt(stk.nextToken());
		for(int i = 0; i < edges;i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			graph[s][end] = true;
			graph[end][s] = true;
		}
		dfs(start);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(start);
	}
	public static void dfs(int v) {
		
		visited[v] = true;
		System.out.print(v+" ");
		for(int i = 1; i<=SIZE; i++) {
			if(graph[v][i]&&!visited[i]) {
				dfs(i);
			}
		}
		
	}
	public static void bfs(int v) {
		Queue<Integer> q= new LinkedList();
		q.add(v);
		while (!q.isEmpty()) {
			v = q.poll();
			if(!visited[v]) {
				visited[v] = true;
				System.out.print(v+" ");
				for(int i = 1; i <= SIZE; i++) {
					if(graph[v][i]) {
						q.add(i);
					}
				}
			}
			
		}
		
	}

}
