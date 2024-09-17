import java.util.*;

class Solution {
     public int[] solution(int n, String[] words) {
        int[] answer = {};
        String before = words[0].charAt(0) +"";
        HashSet<String> spoke = new HashSet<>();
        int error = -1;
        int turn = 0;
        for(int i = 0 ; i < words.length; i++){
            error = (error +1) % n;
            if(error ==0){
                turn +=1;
            }
            String compare = words[i];
            char beforeLastChar = before.charAt(before.length()-1);
            if(beforeLastChar != compare.charAt(0) || spoke.contains(compare)){
                return new int[]{error+1,turn};

            }
            before = compare;
            spoke.add(compare);
        }

        return new int[]{0,0};
    }
}