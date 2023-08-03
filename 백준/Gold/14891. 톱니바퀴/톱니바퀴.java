import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Gear {

	Deque<Integer> dq1 = new LinkedList<>();
	Deque<Integer> dq2 = new LinkedList<>();
	Gear left = null;
	Gear right = null;

	public Gear(char[] arr) {
		for (int i = 0; i < 4; i++) {
			dq1.addLast(arr[i] - '0');

		}
		for (int i = 4; i < 8; i++) {

			dq2.addLast(arr[i] - '0');
		}

	}

	public void SpinRight() {

		dq2.addFirst(dq1.pollLast());
		dq1.addFirst(dq2.pollLast());

	}

	public void SpinLeft() {
		// 왼쪽으로 1회전
		dq2.addLast(dq1.pollFirst());
		dq1.addLast(dq2.pollFirst());

	}

	public int getLeft() {
		SpinRight();
		SpinRight();
		int temp = dq1.getFirst();
		SpinLeft();
		SpinLeft();
		return temp;
	}

	public int getRight() {
		SpinRight();
		int temp = dq1.getLast();
		SpinLeft();
		return temp;
	}

	public int getNorth() {
		return dq1.getFirst();
	}

	public void SpinLeftAllGear() {

		Gear now = this; // 왼쪽부터 체크
		boolean flag = true;
		ArrayList<Gear> needToLeftSpin = new ArrayList<>(4);
		ArrayList<Gear> needToRightSpin = new ArrayList<>(4);
		needToLeftSpin.add(this);
		while (now.right != null) {
			if (now.right.getLeft() == now.getRight()) {
				break;
			}
			if (flag) {
				needToRightSpin.add(now.right);

			} else {
				needToLeftSpin.add(now.right);
			}
			now = now.right;
			flag = !flag;
		}
		flag = true;
		now = this;

		while (now.left != null) {
			if (now.left.getRight() == now.getLeft()) {
				break;
			}
			if (flag) {
				needToRightSpin.add(now.left);

			} else {
				needToLeftSpin.add(now.left);
			}
			now = now.left;
			flag = !flag;
		}
		for (Gear g : needToLeftSpin) {
			g.SpinLeft();
		}
		for (Gear g : needToRightSpin) {
			g.SpinRight();
		}
	}

	public void SpinRightAllGear() {

		Gear now = this; // 왼쪽부터 체크
		boolean flag = true;
		// 회전할 배열에 추가
		ArrayList<Gear> needToLeftSpin = new ArrayList<>(4);
		ArrayList<Gear> needToRightSpin = new ArrayList<>(4);
		needToRightSpin.add(this);

		while (now.right != null) {
			if (now.right.getLeft() == now.getRight()) {
				break;
			}
			if (flag) {
				needToLeftSpin.add(now.right);
			} else {
				needToRightSpin.add(now.right);
			}
			now = now.right;
			flag = !flag;
		}
		flag = true;
		now = this;

		while (now.left != null) {
			if (now.left.getRight() == now.getLeft()) {
				break;
			}
			if (flag) {
				needToLeftSpin.add(now.left);
			} else {
				needToRightSpin.add(now.left);
			}
			now = now.left;
			flag = !flag;
		}
		for (Gear g : needToLeftSpin) {
			g.SpinLeft();
		}
		for (Gear g : needToRightSpin) {
			g.SpinRight();
		}
	}

	@Override
	public String toString() {
		return "" + dq1 + dq2;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gear gears[] = new Gear[4];
		for (int i = 0; i < 4; i++) {
			gears[i] = new Gear(br.readLine().toCharArray());
		}
		gears[0].right = gears[1];
		gears[0].right.right = gears[2];
		gears[0].right.right.right = gears[3];
		gears[3].left = gears[2];
		gears[3].left.left = gears[1];
		gears[3].left.left.left = gears[0];


		int path = Integer.parseInt(br.readLine());
		for (int i = 0; i < path; i++) {
			// 1은 시계 -1 은 반시계
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(stk.nextToken()) - 1;
			int dulation = Integer.parseInt(stk.nextToken());
			// System.out.println(target);

			if (dulation == 1) {
				//gears[target].SpinRight();

				gears[target].SpinRightAllGear();
			} else {
				gears[target].SpinLeftAllGear();
			}


			//break;

		}
		// System.out.println(gears[0]);
		int result = 0;
		int temp[] = { 1, 2, 4, 8 };
		for (int i = 0; i < 4; i++) {
			result += temp[i] * gears[i].getNorth();
		}
		System.out.println(result);

	}
}
