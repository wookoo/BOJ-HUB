import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		 * 여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		 * 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		 * 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */

	//	System.setIn(new FileInputStream("input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int cakeSize = sc.nextInt();

		int cake[] = new int[cakeSize];
		int peopleSize = sc.nextInt();
		int peopleStart[] = new int[peopleSize];
		int peopleEnd[] = new int[peopleSize];
		int peopleMark[] = new int[peopleSize];

		int maxDiff = 0;
		int maxDiffIndex = -1;
		for(int i = 0; i < peopleSize; i++){
			peopleStart[i] = sc.nextInt();
			peopleEnd[i] = sc.nextInt();

			if(peopleEnd[i] - peopleStart[i] > maxDiff){
				maxDiff = peopleEnd[i] - peopleStart[i];
				maxDiffIndex = i;
			}


			for(int cIndex = peopleStart[i]-1; cIndex < peopleEnd[i]; cIndex++){
				if(cake[cIndex] ==0){
					cake[cIndex] = i+1;
					peopleMark[i]++;
				}
			}
		}
		

		int max = -1;
		int maxIndex = -1;
		for(int i = 0; i < peopleSize;i++){
			if(peopleMark[i] > max){
				max = peopleMark[i];
				maxIndex = i;
			}
		}
		System.out.println(maxDiffIndex+1);
		System.out.println(maxIndex+1);

	}
}