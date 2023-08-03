import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Taste{
	int sour;
	int hate;
	public Taste(int sour, int hate){
		this.sour = sour;
		this.hate = hate;
	}
}

public class Main{

	public static int min = Integer.MAX_VALUE;
	public static void combination(Taste arr[], boolean [] visited, int start, int n, int r){
		if(r == 0){
			print(arr,visited,n);
			return;
		}
		for(int i = start; i < n;i++){
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}


	}
	public static void print(Taste arr[], boolean visited[],int n){
		int sour = 1;
		int hate = 0;
		
		for(int i = 0; i < n; i++){
			
			if(visited[i]){
				
				//System.out.print(arr[i].sweet + " "+ arr[i].dis+" ");
				sour *= arr[i].sour;
				hate += arr[i].hate;
			}
		}
		//System.out.println("\n----");
		
		min = Math.min(min,Math.abs(hate-sour));
		
	}

	public static void main(String args[]) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int SIZE = Integer.parseInt(br.readLine());
		boolean visited[] = new boolean[SIZE];
		Taste tastes[] = new Taste[SIZE];
		for(int i = 0 ; i < SIZE; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int sweet = Integer.parseInt(stk.nextToken());
			int dis = Integer.parseInt(stk.nextToken());
			tastes[i] = new Taste(sweet, dis);
		}
		for(int i = 1 ; i <= SIZE; i++){
			//System.out.println(SIZE +"개 중에서 "+i+"개 뽑기");
			//System.out.println(Arrays.toString(visited));
			combination(tastes, visited, 0, SIZE, i);
			
		}
		System.out.println(min);
	}
}