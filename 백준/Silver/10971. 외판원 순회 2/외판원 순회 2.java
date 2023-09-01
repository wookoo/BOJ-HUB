import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int N;
    static int GRAPH[][];


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        GRAPH = new int[N][N];
        int numbers[] = new int[N];
        for(int i = 0 ; i  <  N; i++){
            numbers[i] = i;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                GRAPH[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int MinCost = Integer.MAX_VALUE;
        do {
            MinCost = Math.min(calc(numbers),MinCost);



        }while (np(numbers));
        System.out.println(MinCost);

    }

    private static boolean np(int numbers[]) {
        int i=N-1;
        while(i>0 && numbers[i-1]>=numbers[i]) --i;

        if(i==0) return false;

        int j=N-1;
        while(numbers[i-1]>=numbers[j])	--j;
        swap(numbers,i-1,j);

        int k=N-1;
        while(i<k) {
            swap(numbers,i++,k--);
        }
        return true;

    }

    private static void swap(int numbers[],int i,int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static int calc(int numbers[]){
        if(GRAPH[numbers[N-1]][numbers[0]] == 0){
            return Integer.MAX_VALUE;
        }
        int temp = 0;
        for(int i = 0; i < N-1; i++){
            if(GRAPH[numbers[i]][numbers[i+1]] == 0){
                return Integer.MAX_VALUE;
            }
            temp += GRAPH[numbers[i]][numbers[i+1]];
        }
        temp += GRAPH[numbers[N-1]][numbers[0]];
        return temp;
    }

}