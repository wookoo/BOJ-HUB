import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int SIZE;

	public static void dfs(int num, int start, int end) {

		if (isPrime(num)) {
			if (start <= num && num < end) {
				System.out.println(num);
				return;
			}
			num *= 10;
			for(int i = 1; i <=9;i++){
				dfs(num+i,start,end);
			}

		}
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {

			if (num % i == 0) {
				return false;
			}
		}
		return true;

	}

	public static boolean isAmazing(int num) {

		int size = SIZE - 1;
		for (int i = size; i >= 0; i--) {
			int div = (int) Math.pow(10, i);
			if (!isPrime(num / div)) {
				return false;
			}

		}
		return true;

	}

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(br.readLine());

		int start = (int) Math.pow(10, SIZE - 1);
		int end = (int) Math.pow(10, SIZE);
		dfs(2,start,end);
		dfs(3,start,end);
		dfs(5,start,end);
		dfs(7,start,end);

	}
}