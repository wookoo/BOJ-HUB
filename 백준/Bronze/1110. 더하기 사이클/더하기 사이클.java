import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data = Integer.parseInt(br.readLine());

		int target = data;
		int cnt = 0;
		do{
			int ten = data/10;
			int one = data%10;
			data = one*10 + (ten + one)%10;
			
			cnt ++;
		}while(data != target);
		System.out.println(cnt);
	}
	
}