import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int SIZE = Integer.parseInt(br.readLine());
		for(int i = 0; i < SIZE; i++){
			for(int j = 1; j < SIZE-i; j++){
				System.out.print(" ");
			}
			for(int j = SIZE-i; j <= SIZE; j++){
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
	
}