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
		char[] line = br.readLine().toCharArray();
		for(int i = 0; i < line.length;i++) {
			arr[line[i]-'a'] ++;
		}
		for(int i = 0 ; i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	
	
		
	}
	
	

}

