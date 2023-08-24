import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{

    static int INNING;
    static int people[] = {1,2,3,4,5,6,7,8};
    static int N = people.length;

    static int MAX = 0;

    static int INNING_SCORE_BOARD[][];
    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        INNING = Integer.parseInt(br.readLine());
        INNING_SCORE_BOARD = new int[INNING][9];
        for(int i = 0; i< INNING; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int  j = 0; j < 9; j++){
                INNING_SCORE_BOARD[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        do {

            int newPlayer[] = new int[9];

            for(int i = 0; i < 3; i++ ){
                newPlayer[i] = people[i];
            }
            for(int i = 3; i < 8; i++){
                newPlayer[i+1] = people[i];
            }


            int score = 0;
//            System.out.println(lineUp);
            int playerIndex = 0;
            for(int inning = 0 ; inning < INNING; inning++){
                int out = 0;
                boolean base[] = {false,false,false};
                while (out < 3){
//                    System.out.println(lineUp);
                    int player = newPlayer[playerIndex];
                    int control = INNING_SCORE_BOARD[inning][player]; // 1 2 3 4  0
                    playerIndex = (playerIndex+1)%9;


                    if(control == 0){
                        out ++;
                    }
                    else if(control == 1){ //1루타
                        if(base[2]){
                            score++;
                        }
                        base[2] = base[1];
                        base[1] = base[0];
                        base[0] = true;
                    }
                    else if(control ==2){ // 2루타
                        if(base[2]){
                            score++;
                        }
                        if(base[1]){
                            score ++;
                        }
                        base[2] = base[0];
                        base[1] = true;
                        base[0] = false;

                    }
                    else if(control ==3){ // 3루타
                        if(base[2]){
                            score++;
                        }
                        if(base[1]){
                            score ++;
                        }
                        if(base[0]){
                            score ++;
                        }
                        base[2] = true;
                        base[1] = false;
                        base[0] = false;
                    }
                    else  if (control == 4){
                        score++;
                        for(int i = 0; i < 3; i++){
                            if(base[i]){
                                score ++;
                            }
                            base[i] = false;
                        }
                    }

                }

            }
//           System.out.println(lineUp);
            MAX = Math.max(MAX,score);

        }while (np());
        System.out.println(MAX);

    }


    private static boolean np() {
        int i=N-1;
        while(i>0 && people[i-1]>=people[i]) --i;

        if(i==0) return false;

        int j=N-1;
        while(people[i-1]>=people[j])	--j;
        swap(people,i-1,j);

        int k=N-1;
        while(i<k) {
            swap(people,i++,k--);
        }
        return true;

    }

    private static void swap(int numbers[],int i,int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


}