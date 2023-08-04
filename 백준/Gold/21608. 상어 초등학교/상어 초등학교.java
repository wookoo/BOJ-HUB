import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int freq;
	int near;

	@Override
	public String toString() {
		return "{" +
				" x='" + x + "'" +
				", y='" + y + "'" +
				", freq='" + freq + "'" +
				", near='" + near + "'" +
				"}";
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		// System.out.println(this.x + ","+this.y);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + this.x;
		hash = 71 * hash + this.y;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		Point in = (Point) obj;
		// TODO Auto-generated method stub
		return in.x == this.x && in.y == this.y;
	}

}

public class Main {

	public static int dx[] = { 1, 0, -1, 0 };
	public static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int SIZE = Integer.parseInt(br.readLine());
		//System.out.println(SIZE);
		int seatPos[][] = new int[SIZE * SIZE][2];
		boolean isSeat[] = new boolean[SIZE * SIZE];
		boolean isIn[][] = new boolean[SIZE][SIZE]; // 이거를 grid 로 변경하기, 그후 -1 로 세팅
		int seat[][] = new int[SIZE][SIZE];
		ArrayList<Integer> relation[] = new ArrayList[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++) {
			relation[i] = new ArrayList<Integer>(4);
		}

		for (int i = 0; i < SIZE * SIZE; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int name = Integer.parseInt(stk.nextToken()) - 1;
			HashMap<Point, Integer> candidate = new HashMap<Point, Integer>();
			for (int j = 0; j < 4; j++) {
				int love = Integer.parseInt(stk.nextToken()) - 1;
				relation[name].add(love);
				if (isSeat[love]) {
					// love check
					int pos_x = seatPos[love][0];
					int pos_y = seatPos[love][1];
					for (int index = 0; index < 4; index++) {
						int tx = pos_x + dx[index];
						int ty = pos_y + dy[index];
						if (0 <= tx && tx < SIZE &&
								0 <= ty && ty < SIZE &&
								!isIn[tx][ty]) { // 선택좌표에 앉아있지 않으면 추가
							Point temp = new Point(tx, ty);
							Object t = candidate.get(temp);
							if (t == null) {
								candidate.put(temp, 1);
							} else {

								candidate.put(temp, 1 + (Integer) t);
							}
						}
					}
				}
				// 후보 추가
			}

			Set<Point> keySets = candidate.keySet();
			Iterator<Point> iter = keySets.iterator();
			ArrayList<Point> can = new ArrayList<>();
			while (iter.hasNext()) {
				Point t = iter.next();
				int r = candidate.get(t);
				// 여기서 t 를 가지고 주변에 찾아야됨

				for (int index = 0; index < 4; index++) {
					int tx = t.x + dx[index];
					int ty = t.y + dy[index];
					if (0 <= tx && tx < SIZE && 0 <= ty && ty < SIZE && !isIn[tx][ty]) {
						t.near++;
					}

				}
				t.freq = r;
				can.add(t);
			}

			if (can.size() == 0) {
				for (int x = 0; x < SIZE; x++) {
					for (int y = 0; y < SIZE; y++) {
						if (!isIn[x][y]) {

							Point t = new Point(x, y);

							for (int index = 0; index < 4; index++) {
								int tx = t.x + dx[index];
								int ty = t.y + dy[index];
								if (0 <= tx && tx < SIZE && 0 <= ty && ty < SIZE && !isIn[tx][ty]) {
									t.near++;
								}

							}
							can.add(t);

						}
					}
				}
			} // else {
			// System.out.println(can);
			Collections.sort(can, (o1, o2) -> {
				if (o1.freq == o2.freq) {
					if (o1.near == o2.near) {
						if (o1.x == o2.x) {
							return o1.y - o2.y;
						}
						return o1.x - o2.x;
					}
					return o2.near - o1.near;
				}

				return o2.freq - o1.freq;
			});
			Point choice = can.get(0);
			seatPos[name][0] = choice.x;
			seatPos[name][1] = choice.y;
			isSeat[name] = true;
			isIn[choice.x][choice.y] = true;
			// System.out.println(can);
			// System.out.println((name+1) + " " + choice.x + " " + choice.y);
			seat[choice.x][choice.y] = name + 1;
			// break;
			// }

		}
		int result = 0;
		for (int i = 0; i < SIZE * SIZE; i++) {
			ArrayList<Integer> rl = relation[i];
			int cx = seatPos[i][0];
			int cy = seatPos[i][1];
			int cnt = 0;
			for (int love : rl) {
				int lx = seatPos[love][0];
				int ly = seatPos[love][1];
				if (Math.abs(cx - lx) + Math.abs(cy - ly) == 1) {
					cnt++;
				}

			}
			if (cnt == 1) {
				result += 1;
			} else if (cnt == 2) {
				result += 10;
			}
			else if(cnt ==3){
				result += 100;
			}
			else if(cnt ==4){
				result +=1000;
			}
		}
		System.out.println(result);

	}

}