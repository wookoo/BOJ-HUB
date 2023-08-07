import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in)); 

		StringTokenizer stk = new StringTokenizer(br.readLine());//, null, false)
		int a = Integer.parseInt(stk.nextToken());
		int b= Integer.parseInt(stk.nextToken());
		Queue<Integer> q = new LinkedList();
		for(int i = 1; i <=a; i++){
			q.add(i);
			
		}
		ArrayList<Integer> arr = new ArrayList<>();
		while(!q.isEmpty()){
			for(int i = 0; i <b-1;i++){
				int temp = q.remove();
				q.add(temp);
			}
			arr.add(q.remove());
			
		}

		String result = arr.toString();
		result  = result.replace('[', '<').
		replace(']', '>');
		System.out.println(result);
		


	}

}