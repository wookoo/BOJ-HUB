class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String s: logs){
            if (s.equals("../")){
                depth = depth >= 1 ? depth-1: 0;
            }
            else if(s.equals("./")){

            }
            else{
                depth +=1;
            }
        }
        return depth;
        
    }
}