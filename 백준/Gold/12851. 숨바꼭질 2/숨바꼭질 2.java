import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

       // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());
        Queue<int[]> q = new LinkedList<>();
        int visited[] = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        q.add(new int[]{start, 0});
        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        while (!q.isEmpty()) {
            int info[] = q.poll();
            int pos = info[0];
            int depth = info[1];
            if (pos == end) {
                if(ans >= depth){
                    ans = depth;
                    cnt ++;
                }
//                System.out.println("depth " + depth);
                continue;
            }
            if (depth <= visited[pos]) {
                visited[pos] = depth;
                if (0 < pos) {

                    q.add(new int[]{pos - 1, depth + 1});

                }
                if (pos + 1 < 100001) {

                    q.add(new int[]{pos + 1, depth + 1});

                }
                if (pos * 2 < 100001) {

                    q.add(new int[]{pos * 2, depth + 1});

                }
            }
        }
        System.out.println(ans);
        System.out.println(cnt);


    }


}
