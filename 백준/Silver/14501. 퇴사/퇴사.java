import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {


	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int SIZE = sc.nextInt();
		int N[] = new int[SIZE];
		int P[] = new int[SIZE];
		int cost[] = new int[SIZE+1];
		for(int t = 0; t < SIZE; t++){
			int index = sc.nextInt();
			int c = sc.nextInt();
			N[t] = index;
			P[t] = c;
		}

		for(int i = 0; i< SIZE; i++){
			int endIndex = N[i];
			int endCost = P[i];
			for(int j = i+endIndex; j <= SIZE;j++ ){
				cost[j] = Math.max(cost[j], cost[i]+endCost);
			}
		}
		System.out.println(cost[SIZE]);
		

	}

}