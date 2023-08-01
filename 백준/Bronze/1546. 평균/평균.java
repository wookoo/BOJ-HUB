import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		int sum = 0;
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int arr[] = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int max = Integer.MIN_VALUE;

		for(int i: arr){
			max = Math.max(max, i);
			
		}
		double result = 0;
		for(int i :arr){
			result += i/(double)max*100;
		}
		System.out.println(result/size);
	}
	
}