import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws  Exception{
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int zero = 0;

        int SIZE = Integer.parseInt(br.readLine());
        for(int i = 0; i < SIZE;i++){
            int line = Integer.parseInt(br.readLine());
            if(line == 0){
                zero ++;
            }
            else if(line > 0){
                positive.add(line);
            }
            else{
                negative.add(line);
            }
        }
        positive.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2)*-1;
            }
        });

        negative.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        int result = 0;

        for(int i = 0 ; i < positive.size()/2;i++){
            if(positive.get(i*2+1) == 1){
                result += (positive.get(i*2) + positive.get(i*2+1));
            }
            else{
                result += (positive.get(i*2) * positive.get(i*2+1));
            }
        }
        if(positive.size() %2 ==1){
            result += positive.get(positive.size()-1);
        }
        for(int i = 0 ; i < negative.size()/2; i ++){
            result += (negative.get(i*2) * negative.get(i*2+1));
        }
        if(negative.size() %2 ==1){
           if(zero == 0){
               result += negative.get(negative.size()-1);
           }
        }
        System.out.println(result);






    }
}