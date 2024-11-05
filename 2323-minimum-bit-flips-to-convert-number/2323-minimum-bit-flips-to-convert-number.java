class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for(int i = 0 ; i <32; i++){
            int a = (start >> i) & 1;
            int b = (goal >> i)&1;
            if(a!=b){
                ans++;
            }
            
        }
        return ans;
    }
}