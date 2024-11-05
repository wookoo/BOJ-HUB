import java.util.*;
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        StringTokenizer stk = new StringTokenizer(s1);
        while (stk.hasMoreTokens()) {
            String word = stk.nextToken();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else{
                map.put(word, 1);
            }
        }
        stk = new StringTokenizer(s2);
        while (stk.hasMoreTokens()) {
            String word = stk.nextToken();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else{
                map.put(word, 1);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String key: map.keySet()) {
            int size = map.get(key);
            if(size ==1 ){
                ans.add(key);
            }
        }
        return ans.toArray(new String[0]);

    }
}