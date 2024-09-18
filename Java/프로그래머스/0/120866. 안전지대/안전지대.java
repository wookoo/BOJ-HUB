import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int solution(int[][] board) {
        List<int[]> bombList = new ArrayList<>();
        int N = board.length;
        int M = board[0].length;
        int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    bombList.add(new int[]{i, j});
                }
            }
        }
        for (int [] line : bombList){
            for(int i = 0 ; i <8; i++){
                int tx = line[0]+dx[i];
                int ty = line[1]+dy[i];
                if(0<=tx&&tx<N&&0<=ty&&ty<M && board[tx][ty]==0){
                    board[tx][ty] = 2;
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < N;i ++){
            for(int j = 0 ; j < M;j ++){
                if(board[i][j]==0){
                    ans ++;
                }
            }
        }
        for (int[] line: board){
            System.out.println(Arrays.toString(line));
        }
        return ans;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}));
    }
}