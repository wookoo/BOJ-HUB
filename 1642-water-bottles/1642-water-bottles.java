class Solution {
     public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int blank = numBottles;
        while(blank/numExchange >0){
            ans += blank/numExchange;
            blank = blank%numExchange + blank/numExchange;
        }

        return ans;
    }
}