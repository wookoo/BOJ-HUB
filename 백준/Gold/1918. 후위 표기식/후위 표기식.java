import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
   //     System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> st = new Stack<>();


        char arr[] = br.readLine().toCharArray();

        for(int i = 0; i < arr.length;i++){
            char symbol = arr[i];
            int pushP = pushPriority(symbol);
            if(pushP == 0){
                System.out.print(symbol);
            }
            else if(symbol == '('){
                st.push(symbol);
            }
            else if(symbol == ')'){
                while (st.peek() != '('){
                    System.out.print(st.pop());
                }
                st.pop();
            }
            else{
                while (!st.isEmpty()){
                    char peek = st.peek();
                    int popP = popPriority(peek);
                    if(popP >= pushP){
                        if(peek != ')' && peek != '('){
                            System.out.print(st.pop());
                        }
                        else{
                            st.pop();
                        }
                    }
                    else{
                        break;
                    }
                }
                st.push(symbol);
            }


            //현재 우선순위랑 스택에 있는 우선순위 비교

        }
        while (!st.isEmpty()){
            char symbol = st.pop();
            if(symbol != ')' && symbol != '(') {

                System.out.print(symbol);
            }
        }
    }

    public static int pushPriority(char symbol) {
        switch (symbol) {
            case ')':
                return 1;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 3;
            case '(':
                return 4;
            default :
                return 0;
        }
    }
    public static int popPriority(char symbol) {
        switch (symbol) {
            case ')':
                return 4;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 3;
            case '(':
                return 1;
            default :
                return 0;
        }
    }
}