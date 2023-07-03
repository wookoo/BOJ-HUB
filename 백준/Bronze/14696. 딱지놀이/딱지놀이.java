
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


class Main
{
   

	public static void main(String args[]) throws Exception
	{
		
		//System.setIn(new FileInputStream("input.txt"));


		Scanner sc = new Scanner(System.in);

		int round = sc.nextInt();
		
		for(int i = 0 ; i < round; i++){
		
			int[] firstHand = new int[4];
			int[] secondHand = new int[4];
			int first = sc.nextInt();
			for(int t=0; t<first;t++){
				firstHand[sc.nextInt()-1] +=1;
			}
			int second = sc.nextInt();
			for(int t=0; t<second;t++){
				secondHand[sc.nextInt()-1] +=1;
			}
			String winner = "";
			if(firstHand[3] !=secondHand[3]){
				if(firstHand[3] > secondHand[3]){
					winner = "A";
				}
				else{
					winner ="B";
				} 
			}
			else if(firstHand[2] != secondHand[2]){
				if(firstHand[2] > secondHand[2]){
					winner = "A";
				}
				else{
					winner ="B";
				} 

			}
			else if(firstHand[1] != secondHand[1]){
				if(firstHand[1] > secondHand[1]){
					winner = "A";
				}
				else{
					winner ="B";
				} 

			}
			else if(firstHand[0] != secondHand[0]){
				if(firstHand[0] > secondHand[0]){
					winner = "A";
				}
				else{
					winner ="B";
				} 

			}
			else{
				winner ="D";
			}
			System.out.println(winner);

		}	
	}
}