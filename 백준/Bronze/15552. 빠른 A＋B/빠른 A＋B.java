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

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for(int i =0; i <SIZE;i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			bw.write(String.valueOf(
				Integer.parseInt(stk.nextToken())
				+Integer.parseInt(stk.nextToken())
				
				));
			bw.newLine();
		}
		

		bw.flush();
		

	}


}