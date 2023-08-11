import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	
	static int arr[]= new int[12];



	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test = br.readLine();
		test = test.replace("c=", "0");
		test = test.replace("c-", "0");
		test = test.replace("dz=", "0");
		test = test.replace("d-", "0");
		test = test.replace("lj", "0");
		test = test.replace("nj", "0");
		test = test.replace("s=", "0");
		test = test.replace("z=", "0");
		
		System.out.println(test.length());
		
//		
	}

}
