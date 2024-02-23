import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int move[] = new int[101];
        for (int i = 0; i < 101; i++) {
            move[i] = i;
        }
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int ladders = Integer.parseInt(stk.nextToken());
        int snakes = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < ladders + snakes; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            move[start] = end;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean visited[] = new boolean[101];
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int line[] = q.poll();

            int pos = line[0];
            int depth = line[1];
            if (pos == 100) {
                System.out.println(depth);
                break;

            }
            if (!visited[pos]) {
                visited[pos] = true;
                for (int dice = 1; dice <= 6; dice++) {
                    int toward = pos + dice;
                    if (toward > 100) {
                        break;
                    }
                    toward = move[toward];

                    q.add(new int[]{toward, depth + 1});

                }
            }

        }
    }


}
