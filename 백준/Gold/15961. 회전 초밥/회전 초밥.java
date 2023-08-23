import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {

    public static final String RESET = " \u001B[0m";
    public static final String FONT_BLACK = "\u001B[30m";
    public static final String FONT_RED = "\u001B[31m";
    public static final String FONT_GREEN = "\u001B[32m";
    public static final String FONT_YELLOW = "\u001B[33m";
    public static final String FONT_BLUE = "\u001B[34m";
    public static final String FONT_PURPLE = "\u001B[35m";
    public static final String FONT_CYAN = "\u001B[36m";
    public static final String FONT_WHITE = "\u001B[37m";




    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int D = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        int dishes[] = new int[N];
        for(int i = 0; i < N; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }
        int choice = 1;
        int kind[] = new int[D+1];
        kind[C] = 1;
        for(int i = 0 ; i < K;i++){
            kind[dishes[i]]++;
            if(kind[dishes[i]] == 1){
                choice ++;
            }
        }
//        System.out.println(Arrays.toString(kind));
//        System.out.println(choice);
        int start = 0;
        int end = K-1;

        int maxSize = choice;
        for(int i = 0 ; i < N ; i++){

            kind[dishes[start]] --;
            if(kind[dishes[start]] == 0){
                choice --;
            }

            start = (start+1)%N;
            end = (end+1)%N;
            kind[dishes[end]]++;
            if(kind[dishes[end]] == 1){
                choice ++;
            }
//            for(int j = 0 ; j <= D;j++){
//                if(j == dishes[start]){
//                    System.out.print(FONT_YELLOW + kind[j]+RESET);
//                }
//                else if(j == dishes[end]){
//                    System.out.print(FONT_GREEN + kind[j]+RESET);
//                }
//                else {
//                    System.out.print(kind[j]+" ");
//                }
//            }
//            System.out.println();
//            System.out.println(choice +"|" + dishes[start] + " "+ dishes[end]);

            maxSize = Math.max(choice,maxSize);
//            System.out.println(start+","+end);
            //슬라이딩 윈도우로 갯수 구하고 작업
        }
        System.out.println(maxSize);
    }
}