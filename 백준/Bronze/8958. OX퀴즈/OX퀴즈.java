import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int path = Integer.parseInt(br.readLine());
		for(int i =0; i < path;i++){
			char arr[] = br.readLine().toCharArray();
			int s = 0;
			int result = 0;
			for(int j = 0; j < arr.length; j++){
				
				if(arr[j] == 'X'){
					s = 0;
				}
				else{
					s++;
				}
				result += s;
			
			}
			System.out.println(result);
		}
	}
	
}