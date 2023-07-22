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

		//System.setIn(new FileInputStream("input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		// 숫자 1의 갯수가 몇개인지 세볼까 2차원 배열을 만들고
		int size = sc.nextInt();
		int arr[] = new int[size+1];
		for (int i = 1; i < size+1; i++) {
			arr[i] = sc.nextInt();
		}
		int press = sc.nextInt();
		// System.out.println(Arrays.toString(arr));
		for (int i = 0; i < press; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			if (gender == 1) {
				for (int index = 1; index <= size; index++) {
					if (index  % number == 0) {
						arr[index] = arr[index] == 1 ? 0 : 1;
					}
				}
			} else {
				if (number == 1) {
					// 1번 index swap
					arr[1] = arr[1] == 1 ? 0 : 1;
				} else if (number == size ) {
					arr[size] = arr[size] == 1 ? 0 : 1;
					// size-2 swap
				} else {
					// 중간 비교후 1개씩 뺴기
					if(arr[number-1]!= arr[number+1]){
						arr[number] = arr[number] == 1 ? 0 : 1;
					}
					else{
						int x = number -1;
						int y = number +1;
						while(true){
							if(x == 0){
							
								break;
							}
							if(y == size+1){
								break;
							}
							if(arr[x] != arr[y]){
								break;
							}
							x-=1;
							y+=1;
						}
						x+=1;
						y-=1;
						for(int start = x; start <=y; start++){
							arr[start] = arr[start] == 1 ? 0 : 1;
						}

					}

					// System.out.println("x" + x +"y"+ y);
				}

			}

		}
		for (int i = 1; i <= size; i++) {
			System.out.print(arr[i] + " ");
			if (i  % 20 == 0) {
				System.out.println();
			}
		}
		// System.out.println(s);
	}
}