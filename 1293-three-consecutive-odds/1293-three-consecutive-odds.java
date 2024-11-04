class Solution {
     public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length <=2){
            return false;
        }
        for(int i = 0 ; i < arr.length-2; i++){
            boolean ans = true;
            for(int j = i; j < i+3; j++){
                if(arr[j]%2 != 1){
                    ans = false;
                    break;
                }
            }
            if(ans){
                return ans;
            }
        }
        return false;
    }
}