import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;

public class Main {


	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result[] = new int[42];
		for(int i = 0; i < 10;i++){
			result[Integer.parseInt(br.readLine())%42]++;
			
		}
		int cnt = 0;
		for(int i =0; i < 42;i++){
			if(result[i]!=0){
				cnt++;
			}
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		

	}


}