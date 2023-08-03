import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main
{
	public static int arr[] = new int[(int) Math.pow(10, 6)+1];

	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int SIZE = Integer.parseInt(br.readLine());
		

		for(int i = 2; i <= SIZE;i++){
			arr[i] = arr[i-1]+1;
			if(i%3==0){
				arr[i] = Math.min(arr[i/3]+1, arr[i]);
			}
			if(i%2==0){
				arr[i] = Math.min(arr[i/2]+1, arr[i]);
			}
			
		}
		System.out.println(arr[SIZE]);
		

	}

}