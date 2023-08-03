import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{


	static int targetX;
	static int targetY;
	static int grid[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	public static int bfs(int x, int y) {
		int visited[][] = new int[targetX][targetY];


		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		visited[x][y] = 1;
		while(!q.isEmpty()){
			int[] pos = q.remove();
			int nx = pos[0];
			int ny = pos[1];
			
			
		
			for(int i =0; i < 4;i++){
				int tx = nx+dx[i];
				int ty = ny+dy[i];
				if (( 0 <=tx && tx < targetX && 0 <=ty && ty <targetY && grid[tx][ty] ==1&& visited[tx][ty]==0 )){
					q.add(new int[]{tx,ty});
					visited[tx][ty] = visited[nx][ny]+1;
				}
			}
			
		}
		

		return visited[targetX-1][targetY-1];
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		targetX = Integer.parseInt(stk.nextToken());
		targetY = Integer.parseInt(stk.nextToken());
		grid = new int[targetX][targetY];
		for(int i = 0 ; i < targetX; i++){
			char line[] = br.readLine().toCharArray();
			for(int j = 0; j < targetY; j++){
				grid[i][j] = line[j] - '0';
			}
		}
		int t = bfs(0,0);
		System.out.println(t);
		

	}

}