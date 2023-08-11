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
		int d1 =Integer.parseInt(br.readLine());
		for(int i = 0 ; i < d1; i++) {
			int t = Integer.parseInt(br.readLine());
			for(int j = 0 ; j < t; j++) {
				System.out.print("=");
			}
			System.out.println();
		}
		
	
		
	}
	
	

}

