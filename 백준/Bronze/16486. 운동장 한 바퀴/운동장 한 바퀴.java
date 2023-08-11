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
		int d1 =Integer.parseInt(br.readLine())*2;
		int d2 =Integer.parseInt(br.readLine())*2;
		double pi = 3.141592;
		pi = d2*pi;
		System.out.println(pi+d1);
		
	
		
	}
	
	

}

