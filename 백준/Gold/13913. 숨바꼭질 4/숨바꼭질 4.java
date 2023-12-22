import javax.management.AttributeList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static final int SIZE = 100007;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());
        boolean checked[] = new boolean[SIZE];

        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[SIZE];
        boolean updated[] = new boolean[SIZE];
        q.add(start);
        visited[start] = start;
        updated[start] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            if(now == end){
                Stack<Integer> st = new Stack<>();
                int last = end;

                while (last != start){
                    if(visited[last] == last){
                        break;
                    }
                    st.push(visited[last]);
                    last = visited[last];
                }
                System.out.println(st.size());
                while(!st.isEmpty()){
                    System.out.print(st.pop() + " ");
                }
                System.out.println(end);
                return;
            }
            if(!checked[now]){
                checked[now] = true;
                if(now +1 < SIZE){
                    if(!updated[now+1]){
                        updated[now+1] = true;
                        visited[now+1]  = now;
                    }
                    q.add(now+1);
                }
                if(now-1>= 0){
                    if(!updated[now-1]){
                        updated[now-1] = true;
                        visited[now-1]  = now;
                    }
                    q.add(now-1);
                }
                if(now*2 < SIZE){
                    if(!updated[now*2]){
                        updated[now*2] = true;
                        visited[now*2]  = now;
                    }
                    q.add(now*2);
                }


            }
        }


    }
}