import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<ArrayList<int[]>>();
    static int SIZE;

    static boolean VISITED[];

    static int WEIGHT[] = null;
    public static void main(String[] args) throws  Exception{
     //   System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        SIZE = Integer.parseInt(stk.nextToken());
        int edges = Integer.parseInt(stk.nextToken());


        int S = Integer.parseInt(br.readLine())-1;

        for(int i = 0 ; i < SIZE; i++){
            graph.add(new ArrayList<int[]>());
        }





        for(int i = 0 ; i < edges ;i ++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken())-1;
            int end = Integer.parseInt(stk.nextToken())-1;

            int weight = Integer.parseInt(stk.nextToken());
            graph.get(start).add(new int[]{end,weight});
        }
        WEIGHT = new int[SIZE];


        Arrays.fill(WEIGHT,Integer.MAX_VALUE);
        for(int[] i : graph.get(S)){
            if(WEIGHT[i[0]] > i[1]){
                WEIGHT[i[0]] = i[1];
            }

        }

        VISITED = new boolean[SIZE];
        VISITED[S] = true;
        WEIGHT[S] = 0;


        for(int i = 0 ; i < SIZE; i++){
            int minDirection = Integer.MAX_VALUE;
            int choiceNode = -1;

            for(int j = 0; j < SIZE; j++){
                if(!VISITED[j]&& WEIGHT[j] < minDirection ){
                    minDirection = WEIGHT[j];
                    choiceNode = j;
                }
            }
            //여기서 비용 갱신 진행
            if(choiceNode == -1){
                break;
            }
            VISITED[choiceNode] = true;
            ArrayList<int[]> choice = graph.get(choiceNode);
            for (int[] line : choice) {

                int end = line[0];
                int tempWeight = line[1];
                if(tempWeight == Integer.MAX_VALUE){
                    continue;
                }

                if (!VISITED[end] && tempWeight + minDirection <= WEIGHT[end]
                ) {
                    WEIGHT[end] = tempWeight + minDirection;
                }
            }

        }
        for(int i : WEIGHT){
            if(i == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(i);
            }
        }
    }
}