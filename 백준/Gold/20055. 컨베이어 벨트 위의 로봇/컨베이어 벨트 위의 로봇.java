import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Belt{
		int unBreaking;
		boolean onRobot;
		public Belt(int unBreaking){
			this.unBreaking = unBreaking;
			this.onRobot = false;
		}

	@Override
	public String toString() {
		return "{" +
			" unBreaking='" + unBreaking + "'" +
			", onRobot='" + onRobot + "'" +
			"}";
	}
		
	}



public class Main {

	
	static Deque<Belt> dq1 = new LinkedList<>();
	static Deque<Belt> dq2 = new LinkedList<>();
	static int N;
	static int K;

	public static void SpinBelt(){
		//1회전
		dq1.addFirst(dq2.pollLast());
		Belt t = dq1.pollLast(); 
		dq2.addFirst(t);
		dq1.getLast().onRobot = false; //여기서 로봇 내리기
	}
	public static void SpinRobot(){
		Belt last = dq1.pollLast(); //항상 로봇은 없을꺼임
		for(int i = 0 ; i < N-1;i++){
			Belt moveTarget = dq1.pollLast();
			if(moveTarget.onRobot && !last.onRobot && last.unBreaking >0){
				moveTarget.onRobot = false;
				last.onRobot = true;
				last.unBreaking --;
			}
			dq1.addFirst(last);
			last = moveTarget;
		}
		dq1.addFirst(last);
		dq1.getLast().onRobot = false;
	}
	public static void loadRobot(){
		Belt first = dq1.getFirst();
		if(first.unBreaking >0){
			first.unBreaking --;
			first.onRobot = true;
		}
	}
	public static boolean isFinish(){
		int t = 0;
		for(int i = 0; i < N; i++){
			Belt temp = dq1.pollLast();
			if(temp.unBreaking == 0){
				t++;
			}
			dq1.addFirst(temp);
			Belt temp2 = dq2.pollLast();
			if(temp2.unBreaking == 0){
				t++;
			}
			dq2.addFirst(temp2);
		}
		return K<=t;
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dq1.addLast(new Belt(Integer.parseInt(stk.nextToken())));
		}
		for (int i = 0; i < N; i++) {
			dq2.addLast(new Belt(Integer.parseInt(stk.nextToken())));
		}
		int cnt = 0;
		while(!isFinish()){
			cnt++;
			SpinBelt();
			SpinRobot();
			loadRobot();

		}
		System.out.println(cnt);


	}
}
