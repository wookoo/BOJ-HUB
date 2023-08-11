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
		int first = 0;
		for(int i = 0; i < 4;i++) {
			first+=Integer.parseInt(stk.nextToken());
		}
		stk = new StringTokenizer(br.readLine());
		int second = 0;
		for(int i = 0; i < 4;i++) {
			second+=Integer.parseInt(stk.nextToken());
		}
		System.out.println(Math.max(first, second));
	
		
	}
	
	

}

