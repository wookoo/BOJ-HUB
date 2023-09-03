import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int SIZE;
    static int GRAPH[][];
    static boolean VISITED[][];

    static int ans = Integer.MAX_VALUE;

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());
        GRAPH = new int[SIZE][SIZE];
        VISITED = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                GRAPH[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        ArrayList<ArrayList<int[]>> ed = new ArrayList<>();

        int depth = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GRAPH[i][j] == 1 && !VISITED[i][j]) {
                    depth++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] line = queue.poll();
                        int cx = line[0];
                        int cy = line[1];
                        if (!VISITED[cx][cy]) {
                            VISITED[cx][cy] = true;
                            GRAPH[cx][cy] = depth;


                            boolean isEdge = false;
                            for (int index = 0; index < 4; index++) {
                                int nx = cx + dx[index];
                                int ny = cy + dy[index];
                                if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE ) {
                                    if(!VISITED[nx][ny] && GRAPH[nx][ny] == 1){
                                        queue.add(new int[]{nx, ny});
                                    }
                                    if(GRAPH[nx][ny] == 0){
                                        isEdge = true;
                                    }

                                }

                            }
                            if(isEdge){
                                if(ed.size() == depth-2){
                                    ed.add(new ArrayList<>());
                                }
                                ed.get(depth-2).add(new int[]{cx,cy});
                            }

                        }
                    }
                }
            }
        }
        boolean ch[] = new boolean[ed.size()];
        combination(ed,ch,0,ed.size(),2);
        System.out.println(ans);


//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                String color = exit;
//
//                for (int[] a : ed) {
//                    if (a[0] == i && a[1] == j) {
//                        color = yellow;
//                        break;
//                    }
//                }
//                System.out.print(color + GRAPH[i][j] +" "+ exit);
//            }
//            System.out.println();
//
//        }


    }

    static void combination(ArrayList<ArrayList<int[]>> ed,boolean[] choice,int start,int n, int r){
        if(ans == 1){
            return;
        }
        if(r == 0){


            ArrayList<ArrayList<int[]>> pick = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (choice[i]) {
                    pick.add(ed.get(i));
//                    System.out.print(i+",");
                }
            }
            ArrayList<int[]> first = pick.get(0);
            ArrayList<int[]> second = pick.get(1);

            for (int[] a: first){
                int ax = a[0];
                int ay = a[1];
                for (int[] b: second){
                    int bx  = b[0];
                    int by =  b[1];
                    int d = Math.abs(ax-bx) + Math.abs(ay-by)-1;
                    ans = Math.min(d,ans);
                }
            }

            return;
        }

        for(int i=start; i<n; i++) {
            choice[i] = true;
            combination(ed, choice, i + 1, n, r - 1);
            choice[i] = false;
        }
    }

}