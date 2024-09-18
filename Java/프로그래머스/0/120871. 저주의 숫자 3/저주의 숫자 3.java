class Solution {
    public int solution(int n) {
        int ans = 0 ;
        while (n >0){
            ans ++;
            if((ans+"").contains("3")|| ans%3==0){
                continue;
            }
            n--;
        }
        return ans;
    }

}