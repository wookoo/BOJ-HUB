import java.util.*;
class Solution {
    public boolean isCircularSentence(String sentence) {
        StringTokenizer stk = new StringTokenizer(sentence);
        String pivot = stk.nextToken();
        if(!stk.hasMoreTokens()){
            return pivot.charAt(0) == pivot.charAt(pivot.length()-1);
        }
        String first = pivot;
        while(stk.hasMoreTokens()){
            String temp = stk.nextToken();
            char last = pivot.charAt(pivot.length()-1);
 
            if(last!=temp.charAt(0)){
                return false;
            }
            pivot = temp;

        }
        String temp = first;
        char last = pivot.charAt(pivot.length()-1);
 
            if(last!=temp.charAt(0)){
                return false;
            }
            pivot = temp;
        return true;
    }
}