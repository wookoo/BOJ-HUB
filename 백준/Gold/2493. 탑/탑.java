import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//, null))
		int cnt = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine());// , null, false)
		int arr[] = new int[cnt];
		int recieve[] = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		for (int j = 1; j < cnt; j++) {
			int top = j-1;
			if(arr[j-1]<arr[j]){
				top = recieve[j-1];
			}

			for(; top >=0; top--){
				if(arr[top] > arr[j]){
					recieve[j] = top+1;
					break;
				}
				
			}
		}
		for(int i = 0 ; i < cnt;i++){
			bw.write(recieve[i] +" ");
		}
		bw.flush();
	}

}