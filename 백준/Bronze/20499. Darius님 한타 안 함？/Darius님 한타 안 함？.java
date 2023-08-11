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
		StringTokenizer stk = new StringTokenizer(br.readLine(),"/");
		int K = Integer.parseInt(stk.nextToken());
		int D = Integer.parseInt(stk.nextToken());
		int A = Integer.parseInt(stk.nextToken());
		
		if(K+A <D || D ==0) {
			System.out.println("hasu");
		}
		else {
			System.out.println("gosu");
		}
		
	
		
	}
	
	

}

