import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    static boolean VISITED[] = null;


    static int people[] = null;
    static int AREA;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws Exception {


       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        AREA = Integer.parseInt(br.readLine());

        people = new int[AREA];
        VISITED = new boolean[AREA];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < AREA; i++) {
            people[i] = Integer.parseInt(stk.nextToken());
            graph.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < AREA; i++) {
            ArrayList<Integer> temp = graph.get(i);
            stk = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(stk.nextToken());
            for(int j = 1 ; j <= size ;j++){
                temp.add(Integer.parseInt(stk.nextToken())-1);
            }
        }

//        System.out.println(graph);

        for (int i = 1; i <= AREA/2; i++) {
            if(ans == 0){
                break;
            }
            combination(0, AREA, i);
        }

        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);
        //여기서 갱신된 값 출력
        //인접리스트로도 만들어볼까



    }

    static void combination( int start, int n, int r) {
        if(ans == 0){
            return;
        }
        if(r == 0) {
//            System.out.println(Arrays.toString(VISITED));

            int trueIndex = -1;
            int falseIndex =  -1;
            for(int i = 0; i < AREA; i++){
                if(VISITED[i]){
                    trueIndex = i;
                }
                else{
                    falseIndex =i;
                }
            }

            boolean tempVisited[] = new boolean[AREA];

            Queue<Integer> trueQ = new LinkedList<>();
            trueQ.add(trueIndex);
            while(!trueQ.isEmpty()){
                int node = trueQ.poll();
                if(!tempVisited[node]){
                    tempVisited[node] = true;
                    ArrayList<Integer> link = graph.get(node);
                    for(int i :link){
                        if(VISITED[i]){
                            trueQ.add(i);
                        }
                    }
                }
            }


            Queue<Integer> falseQ = new LinkedList<>();
            falseQ.add(falseIndex);
            while(!falseQ.isEmpty()){
                int node = falseQ.poll();
                if(!tempVisited[node]){
                    tempVisited[node] = true;
                    ArrayList<Integer> link = graph.get(node);
                    for(int i :link){
                        if(!VISITED[i]){
                            falseQ.add(i);
                        }
                    }
                }
            }
            for(boolean i:tempVisited){
                if(!i) {
                    return;
                }
            }

//            System.out.println(Arrays.toString(tempVisited));

            int trueSum = 0;
            int falseSum = 0;
            for(int i = 0; i < AREA; i++){
                if(VISITED[i]){
                    trueSum+= people[i];
                }
                else{
                    falseSum += people[i];
                }
            }
            int result = Math.abs(trueSum-falseSum);
            ans = Math.min(result,ans);




            //true 들과 false 들로 쪼개고 true 에서 bfs 를 갈겨
            //그 후 인접리스트에서 true 면 하고 아니면 추가하지 마
            //다 계산이 끝났으면 여기서 업데이트를 진행해

            return;
        }

        for(int i=start; i<n; i++) {
            VISITED[i] = true;
            combination(i + 1, n, r - 1);
            VISITED[i] = false;
        }
    }


}