import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<int[]> data = new ArrayList<int[]>();

        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            data.add(new int[]{Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())});

        }
        data.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1],o2[1]) * -1;
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int S = data.get(0)[0];
        int E = data.get(0)[1];



        int ans = 0;
        for(int[] line : data){
            int start = line[0];
            int end = line[1];

            /*
             CASE 1. S <= START <= E ;
             */
            if(S <= start && start <= E){
                E = Math.max(E,end);
            }
            else if (S <= end && end <= E ) {//CASE 2.  S <= END <= E;
                S = Math.min(S,start);
            }
            else{
                ans += E-S;
                S = start;
                E = end;
            }

        }
        ans += (E-S);

        System.out.println(ans);



    }
}