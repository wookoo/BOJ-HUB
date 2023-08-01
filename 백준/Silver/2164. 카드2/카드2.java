import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {

   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       // System.out.println("Hello goorm!");
        Queue<Integer> que = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        for (int i = 1; i <= data; i ++){
            que.offer(i);
        }
        int result = 0;
        int loop = 0;
        while (!que.isEmpty()){
            ++loop;
            result = que.poll();
            if(loop %2 ==0){
                que.offer(result);
            }
            
        }
        System.out.println(result);
    }

}
