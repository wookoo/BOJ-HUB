import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Solution {

    public static class Node implements Comparable<Node> {
        public int key;
        public int cost;
        public Node(int key, int cost) {
            this.key = key;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", cost=" + cost +
                    '}';
        }
    }

    public int solution(int[] priorities, int location) {

        Queue<Node> pq = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            pq.add(new Node(i, priorities[i]));
        }
        int depth = 0;
        while(!pq.isEmpty()) {
            Node max = pq.stream().max(Node::compareTo).get();
            Node node = pq.poll();

            if(max.cost != node.cost){
                pq.add(node);
                continue;
            }
            depth++;
            if(node.key == location) {
                return depth;
            }
        }
        return 0;
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





        System.out.println(solution.solution(progresses,2));



    }


}