import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int SIZE = Integer.parseInt(stk.nextToken());
		int SLIDE = Integer.parseInt(stk.nextToken());
		char arr[] = br.readLine().toCharArray();
		int need[] = new int[4];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {

			need[i] = Integer.parseInt(stk.nextToken());
		}
		int cnt = 0;
		int find[] = new int[4];
		for (int i = 0; i < SLIDE; i++) {
			if (arr[i] == 'A') {
				find[0]++;
			} else if (arr[i] == 'C') {
				find[1]++;
			} else if (arr[i] == 'G') {
				find[2]++;
			} else if (arr[i] == 'T') {
				find[3]++;
			}
		}
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (find[i] < need[i]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			cnt++;
		}
		//System.out.println(cnt);

		int start = 0;
		int end = SLIDE - 1;

		for (int i = 0; i < SIZE - SLIDE; i++) {
			if (arr[start] == 'A') {
				find[0]--;
			} else if (arr[start] == 'C') {
				find[1]--;
			} else if (arr[start] == 'G') {
				find[2]--;
			} else if (arr[start] == 'T') {
				find[3]--;
			}
			start++;
			end++;
			if (arr[end] == 'A') {
				find[0]++;
			} else if (arr[end] == 'C') {
				find[1]++;
			} else if (arr[end] == 'G') {
				find[2]++;
			} else if (arr[end] == 'T') {
				find[3]++;
			}
			flag = true;
			for (int j = 0; j < 4; j++) {
				if (find[j] < need[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
			// System.out.println("start "+start);
			// System.out.println("end : " +end);
			// System.out.println("arrays : "+ Arrays.toString(find));
		}
		System.out.println(cnt);
	}
}