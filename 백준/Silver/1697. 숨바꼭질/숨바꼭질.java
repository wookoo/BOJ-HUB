import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {
    static int SIZE;

    static boolean VISITED[] = new boolean[100001];






    //적 녹 색약
    public static void main(String[] args) throws Exception {
     //   System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());;
        int end = Integer.parseInt(stk.nextToken());

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start,0});
        while (!que.isEmpty()){
            int arr[] = que.poll();
            int temp = arr[0];

            int depth = arr[1];
            if(temp == end){
                System.out.println(depth);
                return;
            }
            if(VISITED[temp]){
                continue;
            }
            VISITED[temp] = true;
            if(0 <= temp-1 ){
                que.add(new int[]{temp-1,depth+1});
            }
            if(temp+1 <100001){
                que.add(new int[]{temp+1,depth+1});
            }
            if(temp*2 <100001){
                que.add(new int[]{temp*2,depth+1});
            }

        }

    }








}