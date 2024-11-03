
class Solution {
    public boolean rotateString(String s, String goal) {
        Queue<Character> que = new LinkedList<Character>();
        
        int maxDepth = s.length();
        if( maxDepth != goal.length()){
            return false;
        }
        for (int i = 0 ; i < maxDepth; i++ ){
            que.add(s.charAt(i));
        }
       
        for (int i = 0 ; i < maxDepth; i++){
            boolean flag = false;
            for(int j = 0 ; j < maxDepth; j++){
                char qChar = (char)( (LinkedList)que).get(j);
                char cmpChar = goal.charAt(j);
                if (qChar != cmpChar){
                    flag = true;
                    char temp = que.poll();
                    que.add(temp);
                    break;
                }
            }
            if (!flag){
                return true;
            }
        }
        return false;
    }
}