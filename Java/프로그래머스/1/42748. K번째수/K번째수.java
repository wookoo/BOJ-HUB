import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();
        for (int[] line : commands) {
            int start = line[0] - 1;
            int end = line[1];
            int target = line[2] - 1;
            System.out.println(start + " " + end + " " + target);
            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));
            System.out.println(arr[target]);
            ans.add(arr[target]);
        }

        return ans;
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    // }
}

