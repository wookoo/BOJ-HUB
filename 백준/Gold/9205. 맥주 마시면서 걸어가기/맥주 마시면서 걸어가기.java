
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	


	public static void main(String[] args) throws IOException {
	

		//System.setIn(new FileInputStream("E:/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int TC = 0; TC < tc; TC ++) {
			int convCount = Integer.parseInt(br.readLine());
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(stk.nextToken());
			int startY = Integer.parseInt(stk.nextToken());
			
			boolean visited[] = new boolean[convCount+1];
			
			int graph[][] = new int[convCount+1][2];
			for(int i = 0 ; i <convCount+1; i++) {
				stk = new StringTokenizer(br.readLine());
				graph[i][0] = Integer.parseInt(stk.nextToken());
				graph[i][1] = Integer.parseInt(stk.nextToken());
			}
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{startX,startY});
			boolean flag = false;
			while(!q.isEmpty()) {
				int[] line = q.poll();
				int x = line[0];
				int y = line[1];
				if(x == graph[convCount][0] && y == graph[convCount][1]) {
					flag = true;
					break;
				}
				for(int near = 0; near < convCount+1; near ++ ) {
				
					if(!visited[near]) {
						int cost = Math.abs(x - graph[near][0]) + Math.abs(y-graph[near][1]);
						if(cost <= 1000) {
							q.add(new int[] { graph[near][0], graph[near][1]});
							visited[near] = true;
						}
					}
					
				}
			}
			if(flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
		
	
		

	
		
		
	}

}
