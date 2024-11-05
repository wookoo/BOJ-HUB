class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int ans = 0;
        for(String s: words){
            boolean flag = false;
            for(int j = 0 ; j < s.length() ; j++){
                if(!set.contains(s.charAt(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans++;
            }
        }
        return ans;
    }
}