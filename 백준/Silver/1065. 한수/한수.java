import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	




	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <=t ;i++) {
			if(i <= 99) {
				cnt++;
			}
			else if(  ((i/100) - (i%100)/10) == (((i%100)/10 - i%10))) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
