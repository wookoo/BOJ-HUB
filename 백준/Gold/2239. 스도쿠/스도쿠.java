import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static ArrayList<int[]> zero_p;
    static int N = 9; // 보드 크기

    public static boolean rowCheck(int r,int c, int num) {
        for (int x = 0; x < N; x++) {
            if(c != x && num == arr[r][x]){
                return false;
            }
        }
        return true;
    }

    public static boolean colCheck(int r, int c, int num) {
        for (int x = 0; x < N; x++) {
            if(r != x && num == arr[x][c]){
                return false;
            }
        }
        return true;
    }

    public static boolean squareCheck(int r, int c, int num) {
        int nc = (c / 3) * 3;
        int nr = (r / 3) * 3;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if(r != nr +x && c != nc +y && arr[nr+x][nc+y] ==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void dfs(int depth,int r, int c, int num) {
        if (depth > 0){
            if( ! rowCheck(r,c,num) || ! colCheck(r,c,num) || !squareCheck(r,c,num)){
                return;
            }
        }

        if (depth >= zero_p.size()){
            for (int i = 0; i < 9; i++){
                for(int j = 0; j< 9; j++){
                    System.out.print(arr[i][j]+"");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int[] line = zero_p.get(depth);
        int nr = line[0];
        int nc = line[1];
        for(int i = 1 ; i<= 9; i++){
            arr[nr][nc] = i;
            dfs(depth+1,nr,nc,i);
            arr[nr][nc] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N][N];
        zero_p = new ArrayList<int[]>();
        for(int i = 0; i < 9; i++){
            char line[] = br.readLine().toCharArray();
            for(int j = 0; j < 9; j++){
                arr[i][j] = line[j]-'0';
                if(line[j] == '0'){
                    zero_p.add(new int[]{i,j});
                }
            }
        }




        dfs(0,0,0,0);
    }
}
