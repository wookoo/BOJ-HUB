import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {


    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> st = new Stack<>();
        Stack<Character> temp = new Stack<>();
        char input[] = br.readLine().toCharArray();
        char target[] = br.readLine().toCharArray();
        char end = target[target.length-1];
        for(char c : input){
            st.push(c);
            if(c == end && st.size() >= target.length){
                temp.clear();
                int loop = 0;
                for(loop = target.length -1; loop >= 0 ; loop--){
                    char now = target[loop];
                    if(st.peek() == now){
                        temp.add(st.pop());
                    }
                    else{
                        break;
                    }
                }
                if(loop != -1){
                    while (!temp.isEmpty()){
                        st.push(temp.pop());
                    }
                }
            }
        }
        if(st.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            for (char c: st){
                bw.write(c+"");
            }
            bw.flush();
        }

    }
}