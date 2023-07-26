import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Robot {

	public static final String RESET = "\u001B[0m";
	public static final String FONT_BLACK = "\u001B[30m";
	public static final String FONT_RED = "\u001B[31m";
	public static final String FONT_GREEN = "\u001B[32m";
	public static final String FONT_YELLOW = "\u001B[33m";
	public static final String FONT_BLUE = "\u001B[34m";
	public static final String FONT_PURPLE = "\u001B[35m";
	public static final String FONT_CYAN = "\u001B[36m";
	public static final String FONT_WHITE = "\u001B[37m";
	public static final String BACKGROUND_BLACK = "\u001B[40m";
	public static final String BACKGROUND_RED = "\u001B[41m";
	public static final String BACKGROUND_GREEN = "\u001B[42m";
	public static final String BACKGROUND_YELLOW = "\u001B[43m";
	public static final String BACKGROUND_BLUE = "\u001B[44m";
	public static final String BACKGROUND_PURPLE = "\u001B[45m";
	public static final String BACKGROUND_CYAN = "\u001B[46m";
	public static final String BACKGROUND_WHITE = "\u001B[47m";



	public int x;
	public int y;
	public char location;
	public int grid[][];
	public int W;
	public int H;
	public int dx;
	public int dy;

	public Robot(int x, int y, char location, int grid[][], int W, int H) {
		this.x = x;
		this.y = y;
		this.location = location;
		this.grid = grid;
		this.W = W;
		this.H = H;
	}

	public void turnLeft() {
		char toward = 'A';
		switch (this.location) {
			case 'N':
				toward = 'L';
				break;
			case 'L':
				toward = 'S';
				break;

			case 'S':
				toward = 'E';
				break;

			default:
				toward = 'N';
				break;
		}
		this.location = toward;
	}

	public boolean checkCleanFront() {
		dx = 0;
		dy = 0;
		switch (this.location) {
			case 'N':
				dx = -1;
				break;
			case 'L':
				dy = -1;
				break;

			case 'S':
				dx = 1;
				break;

			default:
				dy = 1;
				break;
		}
		dx += x;
		dy += y;
		return (0 <= dx && dx < W && 0 <= dy && dy < H && grid[dx][dy] == 0);

	}

	public boolean canClean() {
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			turnLeft();
			if (checkCleanFront()) {
				check = true;
			}
		}
		return check;
	}

	public boolean checkBackMove() {
		dx = 0;
		dy = 0;
		switch (this.location) {
			case 'N':
				dx = 1;
				break;
			case 'L':
				dy = 1;
				break;

			case 'S':
				dx = -1;
				break;

			default:
				dy = -1;
				break;
		}
		dx += x;
		dy += y;
		return (0 <= dx && dx < W && 0 <= dy && dy < H && grid[dx][dy] != 1);
	}

	public void task() {
		int clean = 0;
		while (true) {
			//print();
			if (grid[x][y] == 0) {
				grid[x][y] = 2;
				clean++;
			}
			if (!canClean()) {
				if (!checkBackMove()) {
					System.out.println(clean);
					break;
				} else {
					x = dx;
					y = dy;
				}
			} else {
				for (int i = 0; i < 4; i++) {
					turnLeft();
					if (checkCleanFront()) {

						x = dx;
						y = dy;
						break;
					}
				}
			}
		}
	}

	public void print() {
		System.out.println("\n\n\n\n");
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (i == x && j == y) {
					System.out.print(BACKGROUND_YELLOW + grid[i][j] + " " + RESET);
				} else if (grid[i][j] == 0) {
					System.out.print(FONT_GREEN + grid[i][j] + " " + RESET);
				} else if (grid[i][j] == 2) {
					System.out.print(FONT_YELLOW + grid[i][j] + " " + RESET);
				} else {
					System.out.print(grid[i][j] + " ");
				}
			}
			System.out.println();
		}
	}


}

class Main {

	

	

	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		 * 여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		 * 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		 * 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */

		 //System.setIn(new FileInputStream("input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		//

		int robot_x = sc.nextInt();
		int robot_y = sc.nextInt();
		int robot_d = sc.nextInt();
		int grid[][] = new int[W][H];
		for(int i = 0; i < W; i++){
			for(int j = 0; j < H;j++){
				grid[i][j] = sc.nextInt();
			}
		}

		char location = ' ';
		if (robot_d == 0) {
			location = 'N';
		} else if (robot_d == 1) {
			location = 'E';
		} else if (robot_d == 2) {
			location = 'S';
		} else {
			location = 'L';
		}

		Robot r = new Robot(robot_x, robot_y, location, grid, W, H);
		r.task();

	}

}