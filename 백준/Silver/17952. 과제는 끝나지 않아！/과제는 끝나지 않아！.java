
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


class Task{ //현재 작업
	int remain; //남은 작업량
	int reward; //보상
	public Task(int reward,int remain) {
		this.reward = reward;
		this.remain = remain;
	}
}

public class Main {

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("E:/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());//br.readLine()
		
		Stack<Task> st = new Stack<>();
		Task now = null; //현재 작업
		int total_reward = 0;
		for(int tc = 0; tc < TC; tc++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1){
				int reward = Integer.parseInt(stk.nextToken());
				int remain = Integer.parseInt(stk.nextToken());
				if(now != null && now.remain > 0) { //들어온 작업이있다면, 작업중인것을 스택에 넣고
					st.push(now);
				}
				now = new Task(reward,remain);//새로운 작업 생성
				
			}
			if(now != null && now.remain > 0) {
				now.remain --; //현재진행중인 작업 1 감소
			}
			
			if(now!= null && now.remain == 0) { //만약 현재 작업 이 다 끝나면
				total_reward += now.reward; //보상 수령
				if(!st.isEmpty()) { //스택이 비어있지 않으면
					
					now = st.pop(); //현재 작업을 스택에서 꺼냄
			
				}
				else {
					now = null;//그게 아니면 null 처리 하여서 중복 보상 수령 방지
				}
				
			}
		}
		System.out.println(total_reward);

		
	}
}