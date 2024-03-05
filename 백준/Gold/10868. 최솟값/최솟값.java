import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {

    static int graph[];
    static int input[];

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int items = Integer.parseInt(stk.nextToken());
        graph = new int[items * 4];
        input = new int[items];
        int querys = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < items; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(graph,Integer.MAX_VALUE);
        init(0,items-1,1);
//        System.out.println(Arrays.toString(graph));
        for(int i = 0 ; i < querys ; i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken())-1;
            int end = Integer.parseInt(stk.nextToken())-1;
            int result = interval(0,items-1,1,start,end);
            System.out.println(result);

        }

    }

    public static int init(int start,int end,int index){
        if (start == end){
            graph[index] = input[start];

            return graph[index];
        }
        int mid = (start + end) / 2;
        graph[index] = Math.min(init(start, mid, index * 2) , init(mid + 1, end, index * 2 + 1));
        return graph[index];

    }

    public static void build(int node, int left, int right) {
        if(left == right){
            graph[node] = input[left];
            return;
        }
        int mid = (left + right)/2;
        build(node*2,left,mid);
        build(node*2+1,mid+1,right);
        graph[node] = Math.min(graph[node*2] ,graph[node*2+1]);


    }

    public static int interval(int start,int end,int index,int left,int right){
        if (left > end || right < start){
            return Integer.MAX_VALUE;
        }
        if(left <= start && right >= end){
            return graph[index];
        }
        int mid = (start+end)/2;
        return Math.min(interval(start,mid,index*2,left,right),interval(mid+1,end,index*2+1,left,right));
    }
}