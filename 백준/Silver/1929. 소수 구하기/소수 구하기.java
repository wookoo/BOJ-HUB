import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean prime[] = new boolean[1000001];

	public static void genPrime(){
		prime[1] = true;
		prime[0] = true;
		for(int i = 2; i <= Math.sqrt(1000001); i++) {
        
			// 이미 체크된 배열이면 다음 반복문으로 skip

			if(prime[i] == true) {
				continue;
			}
        
			// i 의 배수들을 걸러주기 위한 반복문
			for(int j = i * i; j < 1000001; j = j+i) {
				prime[j] = true;
			}
		}

	}


	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
	
		int start  = Integer.parseInt(stk.nextToken());
        int end  = Integer.parseInt(stk.nextToken());
        genPrime();
        for(int i = start; i <=end; i++){
            if(prime[i]==false){
                System.out.println(i);
            }
        }


		
	}
}