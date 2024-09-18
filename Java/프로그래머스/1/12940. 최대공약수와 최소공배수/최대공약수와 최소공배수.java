import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public int[] solution(int n, int m) {
        int[] answer = new int[]{gcd(n, m),lcm(n, m)};
        return answer;
    }

    public int gcd(int a, int b) {
        if(a%b == 0) return b;
        return gcd(b,a%b);
    }
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(2,5));
    }
}