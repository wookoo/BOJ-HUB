class Solution {
    public int minLength(String s) {
        while (s.length() != s.replace("AB","").length() || s.length() != s.replace("CD","").length()){
            s = s.replace("AB","");
            s = s.replace("CD","");
        }
        return s.length();
    }
}