import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int calcDirection(Point other){
		return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
	}

	@Override
	public String toString() {
		return "{" +
				" x='" + x + "'" +
				", y='" + y + "'" +
				"}";
	}

}

public class Main {
	public static int TOTAL_MIN = Integer.MAX_VALUE;
	public static int CHOICE;
	public static ArrayList<Point> homes = new ArrayList();
	public static ArrayList<Point> shops = new ArrayList();

	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int SIZE = Integer.parseInt(stk.nextToken());
		CHOICE = Integer.parseInt(stk.nextToken());
		for (int i = 0; i < SIZE; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				int data = Integer.parseInt(stk.nextToken());
				if (data == 1) {
					homes.add(new Point(i, j));
				} else if (data == 2) {
					shops.add(new Point(i, j));
				}
			}
		}
		boolean visited[] = new boolean[shops.size()];
		combination(visited, 0, shops.size(), CHOICE);
		System.out.println(TOTAL_MIN);
		//System.out.println(shops);

	}

	public static void combination(boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			int temp = 0;
			for (Point home : homes) {
				int minDirection = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					if (visited[i]) { // 선택된 치킨집
						Point chicken = shops.get(i);
						minDirection = Math.min(minDirection, chicken.calcDirection(home));
					}
				}
				temp += minDirection;
			}
			TOTAL_MIN = Math.min(TOTAL_MIN, temp);

			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(visited, i + 1, n, r - 1);
			visited[i] = false;
		}

	}

}