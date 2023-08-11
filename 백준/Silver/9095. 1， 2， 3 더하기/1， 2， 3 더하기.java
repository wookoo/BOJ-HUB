import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	
	static int arr[]= new int[12];



	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int i = 4; i <=11; i++) {
			arr[i] = arr[i-3] + arr[i-2]+ arr[i-1];
		}
		for(int i = 0; i < t; i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
		
		
//		
	}

}
