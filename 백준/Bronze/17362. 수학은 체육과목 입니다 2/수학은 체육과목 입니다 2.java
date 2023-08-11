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
		int HANDS[] = {1,2,3,4,5,4,3,2};
		int size = Integer.parseInt(br.readLine())-1;
		int index= size%8;
	
		System.out.println(HANDS[index]);
	
		
	}
	
	

}

