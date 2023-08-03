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
		int SIZE = 9;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i =0; i <SIZE;i++){
			int read =  Integer.parseInt(br.readLine());
			max = Math.max(max, read);
			index = max == read?i+1:index;

		}
		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(index));
		bw.flush();
		

	}


}