class Solution {
    public int passThePillow(int n, int time) {
        int freq =  (n-1)*2;
        int depth = time % freq;
        int dx = 1;
        int start = 1;
        for(int i = 0 ; i < depth; i++){
            start += dx;
            if (start == n){
                dx = -dx;
            }
        }
        return start;
    }
}