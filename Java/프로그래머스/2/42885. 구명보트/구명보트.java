import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if(people[start] + people[end] <= limit) {
                start++;
            }
            answer++;
            end--;
        }
        return answer;
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



        System.out.println(solution.solution(intArr.stream().mapToInt(Integer::intValue).toArray(),100));



    }


}