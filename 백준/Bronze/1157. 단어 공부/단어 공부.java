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
		char line[] = br.readLine().toUpperCase().toCharArray();
		int freq[] = new int['Z'-'A'+1];
	
		for(int i =0; i < line.length;i++){
			freq[line[i]-'A']++;
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0; i <'Z'-'A'+1;i++ ){
			max = max < freq[i] ? freq[i] : max;
			index = max == freq[i] ? i:index;
		}
		Arrays.sort(freq);
		if(freq['Z'-'A'-1] == freq['Z'-'A']){
			bw.write("?");
		}
		else{
			String r = (char)('A'+index)+"";
			bw.write(r);
		}
		
		bw.flush();
		

	}


}