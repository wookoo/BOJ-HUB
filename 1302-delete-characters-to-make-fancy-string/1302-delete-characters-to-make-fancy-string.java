import java.util.*;

class Solution {
    static class Node {
        char c;
        int freq;

        public Node(char c) {
            this.c = c;
            this.freq = 1;
        }
    }

    public String makeFancyString(String s) {
        String ans = "";
        Deque<Node> dq = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dq.isEmpty()) {
                dq.add(new Node(c));
                continue;
            }
            char c1 = dq.peekLast().c;
            if (c == c1) {
                dq.peekLast().freq += 1;
            } else {
                dq.add(new Node(c));
            }
        }
        while (!dq.isEmpty()) {
            Node n = dq.pollFirst();
            if (n.freq < 3) {
                for (int i = 0; i < n.freq; i++) {
                    ans = ans + n.c;
                }
            } else {
                ans = ans + n.c + n.c;
            }
        }
        return ans;
    }

   
}