import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(stk.nextToken());
		int min = Integer.parseInt(stk.nextToken());
		int result = hour * 60 + min - 45;
		if(result < 0){
			result += 24*60;
		}
		System.out.printf("%d %d",result/60,result%60);
	}
	
}