import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        String answer = "";
        for(int i = chars.length-1; i>=0; i--) {
            answer += chars[i];
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));
    }
}