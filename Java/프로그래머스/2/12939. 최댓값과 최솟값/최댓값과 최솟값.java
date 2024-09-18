import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer stk = new StringTokenizer(s);
        List<Integer> items = new ArrayList<Integer>();
        while(stk.hasMoreTokens()){
            int num = Integer.parseInt(stk.nextToken());
            items.add(num);
        }
        Collections.sort(items);
        return items.get(0) + " "+items.get(items.size()-1);
    }
}