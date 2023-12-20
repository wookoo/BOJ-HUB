
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
	
	public static int graph[][];
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};
	public static int HORSE_DX[] = {2,1,-1,-2,-2,-1,1,2};
	public static int HORSE_DY[] = {1,2,2,1,-1,-2,-2,-1};
	public static int WIDTH;
	public static int HEIGHT;
	
	public static int WEIGHT[][][];

	public static void main(String[] args) throws IOException {
	

		//System.setIn(new FileInputStream("E:/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int HORSE = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		HEIGHT = Integer.parseInt(stk.nextToken());
		WIDTH = Integer.parseInt(stk.nextToken());
		
		graph = new int[WIDTH][HEIGHT];
		WEIGHT = new int[HORSE+1][WIDTH][HEIGHT];
		for(int i = 0; i< WIDTH; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < HEIGHT; j++) {
				graph[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		
		//Horse 가 1 이면1과 2 로 갈수 있음
		//HORSE 가  0이면 0과 1로 갈수 있음
		//HORSE 가 HOSRE 면 HORSE 로만 이동할수 있음
		//1은 장애물 0은 빈칸
		Queue<int[]> q = new LinkedList<>();
		
		WEIGHT[0][0][0] =1;
		q.add(new int[] {0,0,0});
		while(!q.isEmpty()) {
			int line[] = q.poll();
			int h = line[0];
			int x = line[1];
			int y = line[2];
			if(x== WIDTH -1 && y == HEIGHT -1) {
				System.out.println(WEIGHT[h][x][y]-1);
				return;
			}
			
			if(h != HORSE) {
				for(int index = 0; index < 8; index++) {
					int tx = x+HORSE_DX[index];
					int ty = y+HORSE_DY[index];
					if(0<=tx && tx < WIDTH && 0<= ty && ty < HEIGHT && WEIGHT[h+1][tx][ty] == 0 && graph[tx][ty] == 0) {
						WEIGHT[h+1][tx][ty] = WEIGHT[h][x][y]+1;
						q.add(new int[] {h+1,tx,ty});
					}
				}
				
			}
			//same case
			for(int index = 0; index < 4; index++) {
				int tx = x+dx[index];
				int ty = y+dy[index];
				if(0<=tx && tx < WIDTH && 0<= ty && ty < HEIGHT && WEIGHT[h][tx][ty] == 0 && graph[tx][ty] == 0) {
					WEIGHT[h][tx][ty] = WEIGHT[h][x][y]+1;
					q.add(new int[] {h,tx,ty});
				}
			}
			
			
		}
		System.out.println(-1);
		
		
		
	}

}
