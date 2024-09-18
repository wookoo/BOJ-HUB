import java.util.*;

class Solution {


    static int ans = 0;

    public static class Data {
        public String word;
        public int count;

        public Data(String word, int count) {
            this.word = word;
            this.count = count;
        }

    }

    public int solution(String begin, String target, String[] words) {

        bfs(begin, target, words);
        return ans;
    }

    public void bfs(String begin, String target, String[] words) {
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(begin, 0));
        boolean[] visited = new boolean[words.length];
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            String word = data.word;
            int count = data.count;
            if(word.equals(target)) {
                ans = data.count;
                return;
            }
            for(int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransform(word, words[i])) {
                    visited[i] = true;  // 현재 단어를 방문했다고 기록
                    queue.add(new Data(words[i], count + 1));  // 다음 단계로 큐에 추가
                }
            }

        }

    }
    private boolean canTransform(String word, String target) {
        int cnt = 0;
        for(int i = 0 ; i < word.length(); i++) {
            if(word.charAt(i) != target.charAt(i)) {
                cnt ++;
            }
        }
        return cnt == 1;
    }




}