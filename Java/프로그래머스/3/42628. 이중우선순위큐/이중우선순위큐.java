import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Solution {


    public int[] solution(String[] operations) {

        int answer[] = {0,0};
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            if (command.equals("I")) {
                maxPq.add(number);
                minPq.add(number);
            } else {
                if (number == 1) {
                    //최대 힙 삭제
                    minPq.remove(maxPq.poll());
                } else {
                    maxPq.remove(minPq.poll());
                }
            }
        }

        if(! maxPq.isEmpty()){
            answer[0] = maxPq.peek();
        }
        if(!minPq.isEmpty()){
            answer[1] = minPq.peek();
        }

        return answer;
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

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int[] progresses = parse(br);


        //System.out.println(solution.solution(new String[]{"apple"}));


    }


}