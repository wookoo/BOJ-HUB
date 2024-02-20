import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stk.nextToken());

        int c = Integer.parseInt(stk.nextToken());
        int cnt = Integer.parseInt(stk.nextToken());
        int arr[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int t = Math.min(r,c);
        for (int i = 0; i < t / 2; i++) {
            spin(arr, i, r - i, i, c - i, cnt);

        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void spin(int arr[][], int sr, int er, int sc, int ec, int cnt) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = sc; i < ec; i++) {
            q.add(arr[sr][i]);
        }
        q.pollLast();
        for (int i = sr; i < er; i++) {
            q.add(arr[i][ec - 1]);
        }
        q.pollLast();
        for (int i = ec - 1; i >= sc; i--) {
            q.add(arr[er - 1][i]);
        }
        q.pollLast();
        for (int i = er - 1; i >= sr; i--) {
            q.add(arr[i][sc]);
        }
        q.pollLast();
        int qSize = q.size();
        cnt = cnt%qSize;
        for (int i = 0; i < cnt; i++) {
            q.add(q.pollFirst());
        }


        for (int i = sc; i < ec - 1; i++) {
            arr[sr][i] = q.pollFirst();
        }
        for (int i = sr; i < er; i++) {
            arr[i][ec - 1] = q.pollFirst();
        }
        for (int i = ec - 2; i >= sc; i--) {
            arr[er - 1][i] = q.pollFirst();
        }

        for (int i = er - 2; i > sr; i--) {
            arr[i][sc] = q.pollFirst();
        }

    }
}