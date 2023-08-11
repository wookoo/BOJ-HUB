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

		StringTokenizer stk = null;
		int sum =0;
		while ( (stk=new StringTokenizer(br.readLine())) !=null & (sum = Integer.parseInt(stk.nextToken())+ Integer.parseInt(stk.nextToken()))!=0  ) {
			System.out.println(sum);
		}
		
	
		
	}
	
	

}

