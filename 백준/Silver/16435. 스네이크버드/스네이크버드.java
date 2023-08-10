import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * @author ssafy
 */
public class Main {


	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
	
		int cnt = Integer.parseInt(stk.nextToken());
		int SIZE = Integer.parseInt(stk.nextToken());
		int arr[]= new int[cnt];
		stk = new StringTokenizer(br.readLine());
		for(int i = 0 ;i < cnt; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0 ; i < cnt; i++) {
			if(arr[i] <=SIZE) {
				SIZE++;
			}
			else {
				break;
			}
		}
		System.out.println(SIZE);
		
	}
	
	

}

