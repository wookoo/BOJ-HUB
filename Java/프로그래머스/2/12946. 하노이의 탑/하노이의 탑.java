import java.util.*;

class Solution {

    static List<int[]> ans = new ArrayList<>();

    public List<int[]> solution(int n) {
     
        hanoi(n,1,3,2);
        return ans;

    }

    public void hanoi(int n,int start, int to , int temp){
        if(n == 1){
            ans.add(new int[]{start, to});
            return;
        }

        hanoi(n-1,start,temp,to);
        ans.add(new int[]{start,to});
        hanoi(n-1,temp,to,start);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2);
        System.out.println(ans);
    }
}