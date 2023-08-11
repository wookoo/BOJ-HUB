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

	static int arr[] = new int['z'-'a'+1];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i < 5;i++) {
			if(Integer.parseInt(stk.nextToken()) == target) {
				cnt++;
			}
		}
		System.out.println(cnt);
	
		
	}
	
	

}

