import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int SIZE, low, high;
        StringTokenizer st = new StringTokenizer(br.readLine());
        SIZE = Integer.parseInt(st.nextToken());
        low = Integer.parseInt(st.nextToken());
        high = Integer.parseInt(st.nextToken());

        int[][] grid = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        int path = 0;

        while (true) {
            int call = 0;
            path += 1;

            int[][] mark = new int[SIZE][SIZE];
            Queue<Pair> q = new LinkedList<>();
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            int cnt = 0;

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    for (int index = 0; index < 4; index++) {
                        int tx = i + dx[index];
                        int ty = j + dy[index];

                        if (0 <= tx && tx < SIZE && 0 <= ty && ty < SIZE && low <= Math.abs(grid[i][j] - grid[tx][ty]) && Math.abs(grid[i][j] - grid[tx][ty]) <= high && mark[tx][ty] == 0) {
                            call += 1;
                            q.add(new Pair(i, j));
                            cnt += 1;

                            while (!q.isEmpty()) {
                                Pair p = q.poll();
                                int nx = p.x;
                                int ny = p.y;

                                for (int k = 0; k < 4; k++) {
                                    int tx2 = nx + dx[k];
                                    int ty2 = ny + dy[k];

                                    if (0 <= tx2 && tx2 < SIZE && 0 <= ty2 && ty2 < SIZE && low <= Math.abs(grid[nx][ny] - grid[tx2][ty2]) && Math.abs(grid[nx][ny] - grid[tx2][ty2]) <= high && mark[tx2][ty2] == 0) {
                                        q.add(new Pair(tx2, ty2));

                                        if (mark[nx][ny] != cnt) {
                                            mark[nx][ny] = cnt;
                                        }
                                        if (mark[tx2][ty2] != cnt) {
                                            mark[tx2][ty2] = cnt;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }

            HashMap<Integer, int[]> dic = new HashMap<>();

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (mark[i][j] == 0) {
                        continue;
                    }
                    if (!dic.containsKey(mark[i][j])) {
                        dic.put(mark[i][j], new int[]{0, 0});
                    }
                    dic.get(mark[i][j])[0] += grid[i][j];
                    dic.get(mark[i][j])[1] += 1;
                }
            }

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (mark[i][j] == 0) {
                        continue;
                    }
                    int avg = dic.get(mark[i][j])[0] / dic.get(mark[i][j])[1];
                    grid[i][j] = avg;
                }
            }

            if (call == 0) {
                break;
            }
        }

        System.out.println(path - 1);
    }
}
