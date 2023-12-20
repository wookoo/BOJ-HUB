
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
	
	public static char graph[][];
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};
	public static int WIDTH;
	public static int HEIGHT;
	public static int WATER_WEIGHT[][];
	public static int GOSUMDOCHI_WEIGHT[][];
	public static void main(String[] args) throws IOException {
	

		//System.setIn(new FileInputStream("E:/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		WIDTH = Integer.parseInt(stk.nextToken());
		HEIGHT = Integer.parseInt(stk.nextToken());
		ArrayList<Point> waters = new ArrayList<>();

		Point gosumdochi = null;
		Point end = null;
		graph = new char[WIDTH][];
		WATER_WEIGHT = new int[WIDTH][HEIGHT];
		GOSUMDOCHI_WEIGHT = new int[WIDTH][HEIGHT];
		for(int i = 0 ; i < WIDTH; i++) {
			graph[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < HEIGHT; j++) {
				if(graph[i][j] == '*') {
					waters.add(new Point(i,j));
					
				}
				else if(graph[i][j] == 'S') {
					gosumdochi = new Point(i,j);
				
				}
				else if(graph[i][j] == 'D') {
					end = new Point(i,j);
				}
			}
		}
		Queue<int[]> q= new LinkedList<>();
		
		
		for(Point water: waters) {
			q.add(new int[] {water.x,water.y});
			WATER_WEIGHT[water.x][water.y] = 1;
		}
		
		while(!q.isEmpty()) {
			int line[] = q.poll();
			int x = line[0];
			int y = line[1];
			for(int index = 0 ; index < 4; index ++) {
				int tx = x+dx[index];
				int ty = y+dy[index];
				if(0<= tx && tx < WIDTH && 0<= ty && ty < HEIGHT && WATER_WEIGHT[tx][ty] == 0) {
					if(graph[tx][ty] != 'D' && graph[tx][ty] != 'X') {
						WATER_WEIGHT[tx][ty] = WATER_WEIGHT[x][y] +1;
						q.add(new int[] {tx,ty});
					}
				}
			}
		}
		
		q.add(new int[] {gosumdochi.x,gosumdochi.y});
		GOSUMDOCHI_WEIGHT[gosumdochi.x][gosumdochi.y] = 1;
		while(!q.isEmpty()) {
			int line[] = q.poll();
			int x = line[0];
			int y = line[1];
			for(int index = 0 ; index < 4; index ++) {
				int tx = x+dx[index];
				int ty = y+dy[index];
				if(0<= tx && tx < WIDTH && 0<= ty && ty < HEIGHT && GOSUMDOCHI_WEIGHT[tx][ty] == 0) {
					int move = GOSUMDOCHI_WEIGHT[x][y] +1;
					if(graph[tx][ty] == 'D') {
						System.out.println(move-1);
						return;
					}
					if(graph[tx][ty] != 'X' && (WATER_WEIGHT[tx][ty] == 0 || WATER_WEIGHT[tx][ty] > move)  ) {
						GOSUMDOCHI_WEIGHT[tx][ty] = move;
						q.add(new int[] {tx,ty});
					}
				}
			}
		}
	
		
		
		System.out.println("KAKTUS");
	}

}
