import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Solution {

    public List<Integer> solution(int[] arr) {
        int answer = 0;

        List<Integer> ans = new ArrayList<>();
        int before = -1;
        for(int num : arr){
            if(num != before){
                before = num;
                //System.out.println(num);
                ans.add(num);
            }
        }
        return ans;
    }


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        String arr = br.readLine().replaceAll(" ", "");

        // [ or ] or , 으로 구분하여 값을 나눔
        String[] strArr = arr.split("\\[|\\]|,|\"");

        List<Integer> intArr = new ArrayList<>();

        for (String s : strArr) {
            // null or 빈문자열이 아니라면 리스트에 추가
            if (s != null & !Objects.equals(s, "")) {
                intArr.add(Integer.parseInt(s));
            }
        }



        System.out.println(solution.solution(intArr.stream().mapToInt(Integer::intValue).toArray()));



    }


}