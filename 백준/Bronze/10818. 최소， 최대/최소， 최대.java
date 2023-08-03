import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int SIZE = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i =0; i <SIZE;i++){
			int read = Integer.parseInt(stk.nextToken());
			min = Math.min(min, read);
			max = Math.max(max, read);
		}
		bw.write(min+" "+max);
		bw.flush();
		

	}


}