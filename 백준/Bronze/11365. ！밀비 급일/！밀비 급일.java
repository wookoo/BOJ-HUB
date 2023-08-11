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
		Stack<Character> st =new Stack<>();
		String line;
		while ( !(line=br.readLine()).equals("END") ) {
			char arr[] = line.toCharArray();
			for(int i = 0 ; i <arr.length; i++) {
				st.push(arr[i]);
			}
			while(!st.isEmpty()) {
				System.out.print(st.pop());
			}
			System.out.println();
		}
		
	
		
	}
	
	

}

