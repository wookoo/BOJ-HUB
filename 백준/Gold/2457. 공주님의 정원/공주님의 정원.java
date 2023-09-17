import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static boolean picked[];
    public static void main(String[] args) throws  Exception{
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<int[]> data = new ArrayList<>();
        picked = new boolean[size];
        for(int tc =0 ; tc < size; tc++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int sM = Integer.parseInt(stk.nextToken());
            int sD = Integer.parseInt(stk.nextToken());
            int eM = Integer.parseInt(stk.nextToken());
            int eD = Integer.parseInt(stk.nextToken());
            int line[] = {MonthToDay(sM,sD),MonthToDay(eM,eD)};
            data.add(line);
        }
        int target = MonthToDay(3,1);

        int end = 0;
        data.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });


        int ans = 0;
        while (!data.isEmpty()) {
            if (target >= MonthToDay(12, 1) || data.get(0)[0] > target) {
                break;
            }

            int iterSize = data.size();

            for (int i = 0; i < iterSize; i++) {
                if (target >= data.get(0)[0]) {
                    if (end <= data.get(0)[1]) {
                        end = data.get(0)[1];
                    }
                    data.remove(0);
                } else {
                    break;
                }
            }
            target = end;
            ans ++;
        }
        if (target < MonthToDay(12,1)){
            System.out.println(0);
        }
        else{

            System.out.println(ans);
        }



    }
    public static boolean check(){
        for(int i = 0; i < picked.length; i++){
            if(!picked[i]){
                return true;
            }
        }
        return false;
    }

    public static int MonthToDay(int month, int day){
//(올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일까지 있으며, 2월은 28
        int result = day;
        switch (month-1){
            case (11):
                result += 30;
            case(10):
                result += 31;
            case (9):
                result += 30;
            case (8):
                result += 31;
            case (7):
                result += 31;
            case(6):
                result += 30;
            case (5):
                result += 31;
            case(4):
                result += 30;
            case (3):
                result += 31;
            case (2):
                result += 28;
            case (1):
                result += 31;
        }
        return  result;

    }
}