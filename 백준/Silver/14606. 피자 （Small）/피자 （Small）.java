import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{

       // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[11];
        arr[1] = 1;
        for(int i = 2; i <= size; i++){
            int big = (int)((i/2.0) +0.5);
            int min = i-big;
//            System.out.print(i +" " + big + " " + min);
            arr[i] = big * min + arr[big] + arr[min];
        }
        System.out.println(arr[size-1]);
    }
}