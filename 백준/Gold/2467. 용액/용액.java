import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int arr[] = new int[size];
        int left = 0;
        int right = size-1;
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int ans_left = 0;
        int ans_right = right;
        int ans = Math.abs(arr[0] + arr[right]);
        while (ans != 0 && left < right){
            int now = arr[left] + arr[right];
            if(Math.abs(now) <= ans){
                ans_left = left;
                ans_right = right;
                ans = Math.abs(now);
               
            }

            if(now < 0){
                left ++;
            }
            else{
                right --;
            }
        }
        System.out.print(arr[ans_left]+" ");
        System.out.println(arr[ans_right]);
    }
}