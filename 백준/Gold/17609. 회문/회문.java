import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < size; tc++){
            char line[] = br.readLine().toCharArray();
            Deque<Character> dq = new LinkedList<>();
            for(int i = 0; i < line.length; i++){
                dq.addLast(line[i]);
            }
            if(isPalindrome(dq)){
                System.out.println(0);
                continue;
            }
            //여기서 Palindrome 이 아닐떄까지 뺴버리기
            while (!dq.isEmpty()){
                int head = dq.peekFirst();
                int end = dq.peekLast();
                if(head == end){
                    dq.pollFirst();
                    dq.pollLast();
                }
                else {
                    break;
                }
            }
            //여기서 head 를 빼고 회문인지 검사
            char temp = dq.pollFirst();
            if(isPalindrome(dq)){
                System.out.println(1);
            }
            else{
                dq.addFirst(temp);
                dq.pollLast();
                if(isPalindrome(dq)){
                    System.out.println(1);
                }
                else{
                    System.out.println(2);
                }

            }



        }
    }

    public static boolean isPalindrome(Deque<Character> dq1){
        Deque<Character> dq =  new LinkedList<>(dq1);
        while (!dq.isEmpty()) {
            char head = dq.peekFirst();
            char end = dq.peekLast();
            if (head == end) {
                dq.pollFirst();
                dq.pollLast();

            }
            else{
                return false;
            }
        }
        return true;
    }
}