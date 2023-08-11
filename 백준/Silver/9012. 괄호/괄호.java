import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	

	static HashMap<Character, Character> map = new HashMap<>();
	
	public static boolean check(String arr) {
		Stack<Character> st = new Stack<>();
		char[] line = arr.toCharArray();
		
		for(int i = 0; i < line.length;i++) {
			char symbol = line[i];
			
			if(map.get(symbol) == '|') {
				st.push(symbol);
			}
			else {
				if(st.isEmpty() || st.pop() != map.get(symbol)) {
					return false;
				}
				
			}
			
		}
		return st.isEmpty();
		
	}
	


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
//		System.out.println("ee");
		map.put('(', '|');
		map.put(')','(');
		for(int i = 1; i <=t ;i++) {
			
			if(check(br.readLine())) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}

		}
	}

}
