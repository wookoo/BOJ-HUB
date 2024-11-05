import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            int top = pq.poll();
            nums[index++] = top;
        }

    }
}