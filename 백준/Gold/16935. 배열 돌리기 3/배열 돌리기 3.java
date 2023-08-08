import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int WIDTH;
	public static int HEIGHT;
	public static int arr[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());// , null, false)
		WIDTH = Integer.parseInt(stk.nextToken());
		HEIGHT = Integer.parseInt(stk.nextToken());
		int CMD = Integer.parseInt(stk.nextToken());
		arr = new int[WIDTH + 1][HEIGHT + 1];
		for (int i = 1; i <= WIDTH; i++) {
			stk = new StringTokenizer(br.readLine());// , null, false)
			for (int j = 1; j <= HEIGHT; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			// System.out.println(Arrays.toString(arr[i]));

		}
		// GridSpinRight();
		// genBlock(2,1);

		stk = new StringTokenizer(br.readLine());//, null, false)
		for (int i = 0; i < CMD; i++) {
			int c = Integer.parseInt(stk.nextToken());
			switch (c) {
				case 1:
					flipHorizon();
					break;
				case 2:
					flipVertical();
					break;
				case 3:
					spinRight();
					break;
				case 4:
					spinLeft();
					break;
				case 5:
					GridSpinRight();
					break;
				case 6:
					GridSpinLeft();
					break;

			}
		}

		print();

	}

	public static void swap(int x1, int y1, int x2, int y2) {
		int temp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = temp;
	}

	public static void GridSpinRight() {
		int temp_arr[][] = new int[WIDTH + 1][HEIGHT + 1];
		int first[][] = genBlock(1, 1);
		int second[][] = genBlock(1, 2);
		int fourth[][] = genBlock(2, 1);
		int thrid[][] = genBlock(2, 2);

		for (int i = 1; i <= WIDTH / 2; i++) {
			for (int j = 1; j <= HEIGHT / 2; j++) {
				temp_arr[i][j] = fourth[i][j];
				temp_arr[i][j + HEIGHT / 2] = first[i][j];
				temp_arr[i + WIDTH / 2][j] = thrid[i][j];
				temp_arr[i + WIDTH / 2][j + HEIGHT / 2] = second[i][j];
			}
		}

		arr = temp_arr;
	}

	public static void GridSpinLeft() {
		int temp_arr[][] = new int[WIDTH + 1][HEIGHT + 1];
		int first[][] = genBlock(1, 1);
		int second[][] = genBlock(1, 2);
		int fourth[][] = genBlock(2, 1);
		int thrid[][] = genBlock(2, 2);

		for (int i = 1; i <= WIDTH / 2; i++) {
			for (int j = 1; j <= HEIGHT / 2; j++) {
				temp_arr[i][j] = second[i][j];
				temp_arr[i][j + HEIGHT / 2] = thrid[i][j];
				temp_arr[i + WIDTH / 2][j] = first[i][j];
				temp_arr[i + WIDTH / 2][j + HEIGHT / 2] = fourth[i][j];
			}
		}

		arr = temp_arr;
	}

	public static void flipHorizon() {
		for (int x = 1; x <= WIDTH / 2; x++) {
			for (int j = 1; j <= HEIGHT; j++) {
				swap(x, j, WIDTH - x + 1, j);
			}
		}
	}

	public static void flipVertical() {
		for (int x = 1; x <= WIDTH; x++) {
			for (int j = 1; j <= HEIGHT / 2; j++) {
				swap(x, j, x, HEIGHT - j + 1);
			}
		}
	}

	public static void spinLeft() {
		int temp_width = HEIGHT;
		int temp_height = WIDTH;
		int temp_arr[][] = new int[temp_width + 1][temp_height + 1];
		int x_index = 0;
		int y_index = 0;
		for (int x = HEIGHT; x >= 1; x--) {
			x_index++;
			y_index = 0;
			for (int y = 1; y <= WIDTH; y++) {
				y_index++;
				temp_arr[x_index][y_index] = arr[y][x];
			}
		}
		WIDTH = temp_width;
		HEIGHT = temp_height;
		arr = temp_arr;

	}

	public static void spinRight() {
		int temp_width = HEIGHT;
		int temp_height = WIDTH;
		int temp_arr[][] = new int[temp_width + 1][temp_height + 1];
		int x_index = 0;
		int y_index = 0;
		for (int x = 1; x <= HEIGHT; x++) {
			x_index++;
			y_index = 0;
			for (int y = WIDTH; y >= 1; y--) {
				y_index++;
				// System.out.print(arr[y][x] +" ");
				temp_arr[x_index][y_index] = arr[y][x];
			}
			// System.out.println();
		}
		WIDTH = temp_width;
		HEIGHT = temp_height;
		arr = temp_arr;
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

	public static int[][] genBlock(int i, int j) {
		int temp[][] = new int[WIDTH / 2 + 1][HEIGHT / 2 + 1];

		int xStart = 1;
		int xEnd = WIDTH / 2;

		int yStart = 1;
		int yEnd = HEIGHT / 2;

		if (i == 2) {
			xStart = WIDTH / 2 + 1;
			xEnd = WIDTH;
		}
		if (j == 2) {
			yStart = HEIGHT / 2 + 1;
			yEnd = HEIGHT;
		}

		int tempX = 1;
		int tempY = 0;

		// System.out.println(xStart +","+xEnd);
		// System.out.println(yStart +","+yEnd);

		for (int x = xStart; x <= xEnd; x++) {
			tempY = 1;
			// System.out.println(tempX);
			for (int y = yStart; y <= yEnd; y++) {
				temp[tempX][tempY++] = arr[x][y];
				// System.out.print("arr x y" + x+","+y+" ");
				// System.out.print(arr[x][y] + " ");
			}
			// System.out.println();
			tempX++;

		}
		return temp;
	}

}