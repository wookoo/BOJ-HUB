class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j= 1 ; j < nums.length-i; j++) {
                if(nums[j]<nums[j-1]) {
                    if(getSizeOfBits(nums[j]) == getSizeOfBits(nums[j-1])){
                        int temp = nums[j-1];
                        nums[j-1] = nums[j];
                        nums[j] = temp;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int getSizeOfBits(int number){
        int result = 0;
        for(int i = 0 ; i < 32; i++){
            result += (number >> i) &1;
        }
        return result;
    }
}