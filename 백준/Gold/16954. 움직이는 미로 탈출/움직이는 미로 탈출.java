import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dx[] = {0, 1, 0, -1, 1, -1, -1, 1,0};
    static int dy[] = {1, 0, -1, 0, 1, 1, -1, -1,0};

    static int ans = 0;


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long map = 0;
        int index = 63;
        for (int i = 0; i < 8; i++) {
            char line[] = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                char symbol = line[j];
                if (symbol == '#') {
                    map |= (1L << index);
                }
                index--;
            }
        }

//        printMap(map);

        dfs(7, 0, 0, map);
//        System.out.println();
        System.out.println(ans);


    }

    static void printMap(long map) {
        int t = 0;
        for (int i = 63; i >= 0; i--) {

            if (t == 8) {
                System.out.println();
                t = 0;
            }
            t++;

            if (((map >> i) & 1) == 1) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
    }

    static void dfs(int x, int y, int depth, long map) {


        if (ans == 1) {
            return;
        }
        if (depth > 7) {
            ans = 1;
            return;
        }
        if (x == 0 && y == 7) {
            ans = 1;
            return;
        }

        for (int i = 0; i < 9; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            int cal = tx + ty * 8;
            if (0 <= tx && tx < 8 && 0<=ty && ty < 8) {
                if (((map >>> 8) & (1L << cal)) == 0 && ((map) & (1L << cal)) == 0) {
                    dfs(tx, ty, depth + 1, map >>> 8);
                }
            }

        }


    }
}