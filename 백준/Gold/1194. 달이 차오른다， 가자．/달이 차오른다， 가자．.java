//package bj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static char grid[][];

    static int WEIGHT[][][];


    //KEY 는 FEDCBA


    static int WIDTH;
    static int HEIGHT;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/bj/BJ_1194.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        WEIGHT = new int[0b1000001][WIDTH][HEIGHT];

        grid = new char[WIDTH][];
        int startX = 0;
        int startY = 0;


        for (int w = 0; w < 65; w++) {
            for (int i = 0; i < WIDTH; i++) {
                Arrays.fill(WEIGHT[w][i], -1);
            }
        }

//        ArrayList<int[]> ends = new ArrayList<>();


        for (int i = 0; i < WIDTH; i++) {
            char[] line = br.readLine().toCharArray();
            grid[i] = line;
            for (int j = 0; j < HEIGHT; j++) {
                if (grid[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
//                if(grid[i][j] == '1'){
//                    ends.add(new int[]{i,j});
//                }
            }
        }

        WEIGHT[0][startX][startY] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, startX, startY});
        while (!q.isEmpty()) {
            int[] line = q.poll();
            int key = line[0];
            int x = line[1];
            int y = line[2];




            int temp = (grid[x][y] -'a');
//            System.out.println(temp);
            int newKey = key;
            if(0 <= temp && temp <= 5){
                newKey |= (1 << temp);
//                System.out.println("====");
//                System.out.println(newKey);
//                System.out.println(key);
//                System.out.println( (char)(temp+'a'));
            }





            ArrayList<Integer> keys = genKeys(newKey);

            for (int index = 0; index < 4; index++) {
                int tx = x + dx[index];
                int ty = y + dy[index];
                if (0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT &&grid[tx][ty] != '#' && WEIGHT[newKey][tx][ty] == -1) {
                    //keys 집기
                    //grid[tx][ty] != '#'
                    //A', 'B', 'C', 'D', 'E', 'F'

                    int door = grid[tx][ty] - 'A';
                    if(0<= door && door <= 5){
                        if(((1 << door) & newKey) == 0){
                            continue;
                        }
                    }
                    for(int k : keys){
                        WEIGHT[k][tx][ty] = WEIGHT[key][x][y] + 1;
                        if(grid[tx][ty] == '1'){
                            System.out.println(WEIGHT[k][tx][ty]);
                            return;
                        }
                        q.add(new int[]{k,tx,ty});
                    }
                }
            }
        }

//        int minCost = Integer.MAX_VALUE;
//        for (int[] line :ends){
//
//            int x = line[0];
//            int y = line[1];
//
//            for(int i = 0; i < 65; i++){
//                if(WEIGHT[i][x][y]  != -1){
//                    minCost = Math.min(minCost,WEIGHT[i][x][y]);
//                }
//            }
//
//        }
//        if(minCost ==Integer.MAX_VALUE){
//            minCost = -1;
//        }
        System.out.println(-1);


        //ends

    }

    public static  ArrayList<Integer>  genKeys(int num){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i <= 6; i ++){
            if((num & (1 << i))!=0 ){
                arr.add(i);
            }
        }
        boolean[] visited = new boolean[arr.size()];
        for(int i = 0 ; i < arr.size(); i++){
            combination(arr,visited,0,arr.size(),i+1,result);
        }
        result.add(0);
        return  result;
    }

    static void combination(ArrayList<Integer> arr, boolean[] visited, int start, int n, int r, ArrayList<Integer> result) {
        if(r == 0) {
            int key = 0;
            for(int i = 0 ; i < visited.length; i++){
                if(visited[i]){
                    int num = arr.get(i);
                    key |= (1 << num);
                }
            }
            result.add(key);
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1,result);
            visited[i] = false;
        }
    }

}

