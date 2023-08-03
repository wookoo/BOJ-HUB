import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main
{
	public static int arr[] = new int[5001];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int SIZE = Integer.parseInt(br.readLine());
		
		arr[3] = 1;
		arr[5] = 1;
		for(int i = 6;i <= SIZE;i++){
			if(i%5 ==0){
				arr[i] = arr[i-5] +1;
			}
			else if(i%3 ==0){
				arr[i] = arr[i-3]+1;
			}
			else{
				if(arr[i-3] != 0 && arr[i-5]!=0){
					arr[i] = Math.min(arr[i-3]+1,arr[i-5]+1);
				}
			}
		}
	    if(arr[SIZE] == 0){
            System.out.println(-1);
            return;
        }
		System.out.println(arr[SIZE]);
		

	}

}