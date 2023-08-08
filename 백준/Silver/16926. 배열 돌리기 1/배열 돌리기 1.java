

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int WIDTH;
	public static int HEIGHT;
	public static int arr[][];

	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());// , null, false)
		WIDTH = Integer.parseInt(stk.nextToken());
		HEIGHT = Integer.parseInt(stk.nextToken());
		int CNT = Integer.parseInt(stk.nextToken());
		arr = new int[WIDTH][HEIGHT];
		for (int i = 1; i <= WIDTH; i++) {
			stk = new StringTokenizer(br.readLine());// , null, false)
			for (int j = 1; j <= HEIGHT; j++) {
				arr[i - 1][j - 1] = Integer.parseInt(stk.nextToken());
			}
			// System.out.println(Arrays.toString(arr[i - 1]));
		}
		int MIN = Math.min(WIDTH, HEIGHT);
		int circuitSIZE = MIN / 2;

		Deque<Integer> circuits[] = new LinkedList[circuitSIZE];


		for (int cSIze = 0; cSIze < circuitSIZE; cSIze++) {

			circuits[cSIze] = new LinkedList<Integer>();
			Deque<Integer> dq = circuits[cSIze];
			for (int i = cSIze; i < HEIGHT - cSIze; i++) {
				dq.addLast(arr[cSIze][i]);
				// System.out.print(arr[cSIze][i] + " ");
			}
			for (int i = cSIze + 1; i < WIDTH - cSIze; i++) {
				dq.addLast(arr[i][HEIGHT - cSIze - 1]);
				// System.out.print(arr[i][HEIGHT - cSIze - 1] + " ");
			}
			for (int i = HEIGHT - 2 - cSIze; i >= cSIze; i--) {
				dq.addLast(arr[WIDTH - 1 - cSIze][i]);

				// System.out.print(arr[WIDTH - 1 - cSIze][i] + " ");
			}
			for (int i = WIDTH - 2 - cSIze; i > cSIze; i--) {
				dq.addLast(arr[i][cSIze]);

				// System.out.print(arr[i][cSIze] + " ");
			}
			// System.out.println();

			// break;
		}




		

		for (int i = 0; i < CNT; i++) {
			for (Deque<Integer> dq : circuits) {
				int temp = dq.pollFirst();
				dq.addLast(temp);
			}
		}


		for (int cSIze = 0; cSIze < circuitSIZE; cSIze++) {

			// circuits[cSIze] = new LinkedList<Integer>();
			Deque<Integer> dq = circuits[cSIze];
			for (int i = cSIze; i < HEIGHT - cSIze; i++) {
				arr[cSIze][i] = dq.pollFirst();
				// System.out.print(arr[cSIze][i] + " ");
			}
			for (int i = cSIze + 1; i < WIDTH - cSIze; i++) {
				arr[i][HEIGHT - cSIze - 1] = dq.pollFirst();
				// System.out.print(arr[i][HEIGHT - cSIze - 1] + " ");
			}
			for (int i = HEIGHT - 2 - cSIze; i >= cSIze; i--) {
				arr[WIDTH - 1 - cSIze][i] = dq.pollFirst();

				// System.out.print(arr[WIDTH - 1 - cSIze][i] + " ");
			}
			for (int i = WIDTH - 2 - cSIze; i > cSIze; i--) {
				arr[i][cSIze] = dq.pollFirst();

				// System.out.print(arr[i][cSIze] + " ");
			}
			// System.out.println();

			// break;
		}
		for(int i = 0 ; i < WIDTH; i++){
			for(int j = 0 ; j < HEIGHT ; j++){
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}

		

	}

	public static void swap(int x1, int y1, int x2, int y2) {
		int temp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = temp;
	}

	public static void print() {
		for (int i = 1; i <= WIDTH; i++) {
			for (int j = 1; j <= HEIGHT; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			// System.out.println(Arrays.toString(arr[i]));
		}
	}

}