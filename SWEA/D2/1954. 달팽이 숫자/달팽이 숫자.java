
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        // Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(sc.readLine());
        for (int tc = 0; tc < test_case; tc++) {
            int size = Integer.parseInt(sc.readLine());
            int arr[][] = new int[size][size];
            int nx = 0;
            int ny = 0;
            int dx[] = { 0, 1, 0, -1 };
            int dy[] = { 1, 0, -1, 0 };
            int move = 0;
            for (int i = 1; i < size * size + 1; i++) {
                arr[nx][ny] = i;
                nx += dx[move];
                ny += dy[move];
                if (nx < 0 || ny < 0 || nx >= size || ny >= size || arr[nx][ny] != 0) {
                    nx -= dx[move];
                    ny -= dy[move];
                    move = (move + 1) % 4;
                    nx += dx[move];
                    ny += dy[move];
                }
            }
            System.out.printf("#%d\n", tc + 1);
            for (int[] i : arr){
                for(int j: i){
                    System.out.print(j+" ");
                }
                System.out.println();
            }

        }
    }
}
