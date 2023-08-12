
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class LineInfo implements Comparable<LineInfo> {

	int R;
	int C;
	int S;
	int num;
	public static int NUM = 0;

	public LineInfo(int R, int C, int S) {
		this.R = R;
		this.C = C;
		this.S = S;
		this.num = NUM;
		NUM++;
	}

	@Override
	public int compareTo(LineInfo o) {
		return Integer.compare(this.num, o.num);

	}

}

public class Main {
	public static int GRID_WIDTH;
	public static int GRID_HEIGHT;

	public static int reference[][];
	public static int arr[][];
	public static int CNT;

	public static int MINRESULT = Integer.MAX_VALUE;

	public static LineInfo needPermutation[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());// , null, false)
		GRID_WIDTH = Integer.parseInt(stk.nextToken());
		GRID_HEIGHT = Integer.parseInt(stk.nextToken());
		CNT = Integer.parseInt(stk.nextToken());
		arr = new int[GRID_WIDTH][GRID_HEIGHT];
		reference = new int[GRID_WIDTH][GRID_HEIGHT];
		for (int i = 1; i <= GRID_WIDTH; i++) {
			stk = new StringTokenizer(br.readLine());// , null, false)
			for (int j = 1; j <= GRID_HEIGHT; j++) {
				reference[i - 1][j - 1] = Integer.parseInt(stk.nextToken());
			}

		}
		needPermutation = new LineInfo[CNT];
		for (int i = 0; i < CNT; i++) {
			stk = new StringTokenizer(br.readLine());// , null, false)
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			int S = Integer.parseInt(stk.nextToken());
			needPermutation[i] = new LineInfo(R, C, S);
		}

		do {
			// 순열을 이용한 처리
			// System.out.println(Arrays.toString(input));

			SpinGrid();
		} while (np(needPermutation));// 다음 순열 찾기

		System.out.println(MINRESULT);
	}

	public static void ResetGrid() {
		for (int i = 0; i < GRID_WIDTH; i++) {
			for (int j = 0; j < GRID_HEIGHT; j++) {
				arr[i][j] = reference[i][j];
			}
		}
	}

	public static void SpinGrid() {
		ResetGrid();
		for (int line = 0; line < CNT; line++) {
			// stk = new StringTokenizer(br.readLine());// , null, false)
			LineInfo l = needPermutation[line];
			int R = l.R;
			int C = l.C;
			int S = l.S;
			int lineWidth = 2 * S + 1;
			int lineHeight = 2 * S + 1;
			int xStart = R - S;
			int yStart = C - S;

			int MIN = Math.min(lineWidth, lineHeight);
			int circuitSIZE = MIN / 2;
			Deque<Integer> circuits[] = new LinkedList[circuitSIZE];
			for (int cSIze = 0; cSIze < circuitSIZE; cSIze++) {
				int entity = (lineWidth - 1) * 2 + (lineHeight - 1) * 2 - (8 * cSIze);

				int x = xStart - 1 + cSIze;
				int y = yStart - 1 + cSIze;

				int yEnd = C + S - 1 - cSIze;
				int xEnd = R + S - 1 - cSIze;
				int xStartLine = x;
				int yStartLine = y;

				// System.out.println("엔티티" + entity+" x좌표 " + x +" y좌표 "+y);
				circuits[cSIze] = new LinkedList<Integer>();
				Deque<Integer> dq = circuits[cSIze];
				int dx[] = { 0, 1, 0, -1 };
				int dy[] = { 1, 0, -1, 0 };
				int index = 0;
				for (int i = 0; i < entity; i++) {
					dq.add(arr[x][y]);
					// System.out.printf("x %d y %d i %d\n",x,y,index);
					y = y + dy[index];
					x = x + dx[index];
					if ((index == 0 && y == yEnd) || (index == 1) && x == xEnd || (index == 2) && y == yStartLine
							|| index == 3 && x == xStartLine) {
						index++;
					}

				}
			}
			for (Deque<Integer> dq : circuits) { // 모든덱 스핀
				int temp = dq.pollLast();
				dq.addFirst(temp);
			}
			for (int cSIze = 0; cSIze < circuitSIZE; cSIze++) { // 원상복귀
				int entity = (lineWidth - 1) * 2 + (lineHeight - 1) * 2 - (8 * cSIze);

				int x = xStart - 1 + cSIze;
				int y = yStart - 1 + cSIze;

				int yEnd = C + S - 1 - cSIze;
				int xEnd = R + S - 1 - cSIze;
				int xStartLine = x;
				int yStartLine = y;

				Deque<Integer> dq = circuits[cSIze];
				int dx[] = { 0, 1, 0, -1 };
				int dy[] = { 1, 0, -1, 0 };
				int index = 0;
				for (int i = 0; i < entity; i++) {
					arr[x][y] = dq.pollFirst();
					// System.out.printf("x %d y %d i %d\n",x,y,index);
					y = y + dy[index];
					x = x + dx[index];
					if ((index == 0 && y == yEnd) || (index == 1) && x == xEnd || (index == 2) && y == yStartLine
							|| index == 3 && x == xStartLine) {
						index++;
					}

				}
			}

		}
		for(int [] line : arr){
			int temp = 0;
			for(int asd:line){
				temp += asd;
			}
			MINRESULT = Math.min(temp, MINRESULT);
		}
		
	}

	private static boolean np(LineInfo numbers[]) {

		// 1. 맨 뒤부터 탐색하며 꼭대기 찾기
		int N = numbers.length;

		int i = N - 1;
		while (i > 0 && numbers[i - 1].num >= numbers[i].num)
			--i;

		if (i == 0)
			return false; // 가장 큰 순열의 형태 - 다음 순열 없음

		// 2.꼭대기 직전[i-1] 위치에 교환할 한단계 큰수 뒤쪽부터 찾기
		int j = N - 1;
		while (numbers[i - 1].num >= numbers[j].num)
			--j;

		// 3.꼭대기 직전[i-1] 위치의 수와 한단계 큰 수 교환하기 - 꼭대기 수가 있어 반드시 교환할 큰 수 존재
		swap(numbers, i - 1, j);

		// 4.꼭대기부터 맨 뒤까지 수 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	private static void swap(LineInfo numbers[], int i, int j) {
		LineInfo temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/*
	 * for (int i = 0; i < CNT; i++) {
	 * for (Deque<Integer> dq : circuits) {
	 * int temp = dq.pollFirst();
	 * dq.addLast(temp);
	 * }
	 * }
	 * 
	 * for (int cSIze = 0; cSIze < circuitSIZE; cSIze++) {
	 * 
	 * // circuits[cSIze] = new LinkedList<Integer>();
	 * Deque<Integer> dq = circuits[cSIze];
	 * for (int i = cSIze; i < HEIGHT - cSIze; i++) {
	 * arr[cSIze][i] = dq.pollFirst();
	 * // System.out.print(arr[cSIze][i] + " ");
	 * }
	 * for (int i = cSIze + 1; i < WIDTH - cSIze; i++) {
	 * arr[i][HEIGHT - cSIze - 1] = dq.pollFirst();
	 * // System.out.print(arr[i][HEIGHT - cSIze - 1] + " ");
	 * }
	 * for (int i = HEIGHT - 2 - cSIze; i >= cSIze; i--) {
	 * arr[WIDTH - 1 - cSIze][i] = dq.pollFirst();
	 * 
	 * // System.out.print(arr[WIDTH - 1 - cSIze][i] + " ");
	 * }
	 * for (int i = WIDTH - 2 - cSIze; i > cSIze; i--) {
	 * arr[i][cSIze] = dq.pollFirst();
	 * 
	 * // System.out.print(arr[i][cSIze] + " ");
	 * }
	 * // System.out.println();
	 * 
	 * // break;
	 * }
	 * for (int i = 0; i < WIDTH; i++) {
	 * for (int j = 0; j < HEIGHT; j++) {
	 * System.out.print(arr[i][j] + " ");
	 * }
	 * System.out.println();
	 * }
	 * 
	 * }
	 * 
	 * 
	 * public static void swap(int x1, int y1, int x2, int y2) {
	 * int temp = arr[x1][y1];
	 * arr[x1][y1] = arr[x2][y2];
	 * arr[x2][y2] = temp;
	 * }
	 * 
	 * public static void print() {
	 * for (int i = 1; i <= WIDTH; i++) {
	 * for (int j = 1; j <= HEIGHT; j++) {
	 * System.out.print(arr[i][j] + " ");
	 * }
	 * System.out.println();
	 * // System.out.println(Arrays.toString(arr[i]));
	 * }
	 * }
	 */

}