import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws  Exception{
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int TC= 1; TC<= tc; TC++){

            StringTokenizer stk = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(stk.nextToken());
            int target = Integer.parseInt(stk.nextToken());
            HashSet<Integer> s = new HashSet<>();


            char line[] = br.readLine().toCharArray();
            int K = size/4;
            for(int i = 0; i < size; i++){
                //SIZE /4

                int num = 0;
                for(int j = 0; j < K; j++){

                    char symbol = line[(i+j)%size];
                    num += Math.pow(16,K-1-j)*charToInt(symbol);
                }

                s.add(num);

            }

            ArrayList<Integer> r = new ArrayList<>(s);
            Collections.sort(r);
            Collections.reverse(r);
//            System.out.println(r);
            System.out.println("#"+TC +" "+r.get(target-1));
        }

    }


    public static int charToInt(char symbol){
        if('A' <= symbol && symbol <= 'F'){
            return symbol-'A' + 10;
        }

        return symbol-'0';
    }
}