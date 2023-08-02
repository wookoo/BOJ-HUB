import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int SIZE = Integer.parseInt(stk.nextToken());
			int arr[] = new int[SIZE];
			for(int index = 0; index <SIZE; index++){
				arr[index] = Integer.parseInt(stk.nextToken());
			}
			double s = 0;
			for (int j:arr){
				s+= j;
			}
			s /= SIZE;
			int cnt = 0;
			for(int j:arr){
				if(j > s){
					cnt ++;
				}
			}
			bw.write(String.format("%.3f%%", cnt/(double)SIZE*100));
			bw.newLine();
			
		}
		bw.flush();

	}
}
