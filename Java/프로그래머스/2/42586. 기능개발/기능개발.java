import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Solution {

    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};

//        System.out.println(Arrays.toString(progresses));
//        System.out.println(Arrays.toString(speeds));


        int before =  (int)Math.ceil( (100-progresses[0]) / (double) speeds[0]);
//        System.out.println(before);



        int temp = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < progresses.length; i++) {
            int day = (int)Math.ceil( (100-progresses[i]) / (double) speeds[i]);
            if (before < day ) {
                before = day;
                ans.add(temp);
                temp = 1;
            }
            else{
                temp++;
            }
        }
        ans.add(temp);

        return ans;
    }


    public static int[] parse(BufferedReader br) throws IOException {

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
        return intArr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int[] progresses = parse(br);
        int[] speeds = parse(br);





        System.out.println(solution.solution(progresses,speeds));



    }


}