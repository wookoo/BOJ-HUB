import java.io.*;
import java.util.*;


public class Main {

    static boolean isEnd = false;

    static int SCORE[][] = new int[6][3];

    static int SQUAD[][] = {

            {0, 1},
            {0, 2},
            {0, 3},
            {0, 4},
            {0, 5},
            {1, 2},
            {1, 3},
            {1, 4},
            {1, 5},
            {2, 3},
            {2, 4},
            {2, 5},
            {3, 4},
            {3, 5},
            {4, 5}
    };


    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            boolean breaked = false;
            for (int j = 0; j < 6; j++) {
                SCORE[j][0] = Integer.parseInt(stk.nextToken());
                SCORE[j][1] = Integer.parseInt(stk.nextToken());
                SCORE[j][2] = Integer.parseInt(stk.nextToken());
                if(SCORE[j][0] + SCORE[j][1] + SCORE[j][2] !=5){
                    breaked = true;
                    break;
                }
//                System.out.println(SCORE[j][0]);
            }
            if(!breaked){
                isEnd = false;
                search(0);
                System.out.print(isEnd?"1 ":"0 ");
            }
            else{
                System.out.print("0 ");
            }


        }


    }

    public static void search(int index) {
        if (index == 15) {
            isEnd = true;
        }
        if(isEnd){
            return;
        }

        int start = SQUAD[index][0];
        int end = SQUAD[index][1];
        if (SCORE[start][0] > 0 && SCORE[end][2] > 0) {
            SCORE[start][0] -= 1;
            SCORE[end][2] -= 1;
            search(index + 1);
            SCORE[start][0] += 1;
            SCORE[end][2] += 1;
        }
        if (SCORE[start][1] > 0 && SCORE[end][1] > 0) {
            SCORE[start][1] -= 1;
            SCORE[end][1] -= 1;
            search(index + 1);
            SCORE[start][1] += 1;
            SCORE[end][1] += 1;
        }
        if (SCORE[start][2] > 0 && SCORE[end][0] > 0) {
            SCORE[start][2] -= 1;
            SCORE[end][0] -= 1;
            search(index + 1);
            SCORE[start][2] += 1;
            SCORE[end][0] += 1;
        }


    }
}
