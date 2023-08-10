import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String args[]) throws Exception {
       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TinyGuy[] = new int[9];
        boolean visited[] = new boolean[9];
        for (int i = 0; i < 9; i++) {
            TinyGuy[i] = Integer.parseInt(br.readLine());
        }
        combination(TinyGuy, visited, 0, 9, 7);

    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (visited[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

}