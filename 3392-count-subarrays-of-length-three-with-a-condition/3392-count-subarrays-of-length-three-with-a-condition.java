class Solution {
   public  int countSubarrays(int[] nums) {
         int a= 0;
        for(int i = 0 ; i < nums.length-2 ; i++){
            if(nums[i+1] ==  2*(nums[i] + nums[i+2])  ){
                a++;
            }
        }

        return a;
    }
}