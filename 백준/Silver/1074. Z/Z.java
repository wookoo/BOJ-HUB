import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[][] GRID;
    static int write = 0;
    static int N;
    static int R;
    static int C;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        int SIZE = (int) Math.pow(2,N);

        solution(0,0,SIZE);


    }
    static void solution(int r, int c, int tempSize){
        if(tempSize == 1){
            System.out.println(ans);
            return;
        }
        int size = tempSize;
        tempSize = tempSize/2;
        if(R < r + tempSize && C < c + tempSize){
            solution(r,c,tempSize);
        }
        else if( R < r+ tempSize && c + tempSize <=C){
            ans += (size*size)/4;
            solution(r,c+tempSize,tempSize);

        }
        else if( r+ tempSize<=R && c + tempSize <=C){
            ans += (size*size)/4;
            ans += (size*size)/4;
            ans += (size*size)/4;
            solution(r+tempSize,c+tempSize,tempSize);

        }
        else{
            ans += (size*size)/4;
            ans += (size*size)/4;

            solution(r+tempSize,c,tempSize);

        }


    }



}