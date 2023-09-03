import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int SIZE;
    static int GRAPH[];
    static boolean VISITED[];
    static boolean FINISH[];
    static int result;
    public static void main(String[] args) throws  Exception{
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int tcs = 0; tcs < tc; tcs++){
            SIZE = Integer.parseInt(br.readLine());
            GRAPH = new int[SIZE];
            VISITED = new boolean[SIZE];
            FINISH = new boolean[SIZE];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < SIZE; i++){
                GRAPH[i] = Integer.parseInt(stk.nextToken())-1;
            }
            result = 0;
            for(int i = 0 ; i < SIZE; i++){
                if(!VISITED[i]){
                    dfs(i);
                }

            }

            System.out.println(SIZE-result);
        }
    }
    public static void dfs(int start){
        VISITED[start] = true;
        int want = GRAPH[start];
        if(!VISITED[want]){
            dfs(want);
        }
        else if( !FINISH[want] ){

            for(int curr = want; curr != start; curr = GRAPH[curr]){
                result ++;
            }
            result ++;
        }
        FINISH[start] = true;

    }
}