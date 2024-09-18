class Solution {
    
    public static int[] numbers;
    public static int target = 0;;
    public static int ans = 0;
    public static int maxIndex = 0;
    public int solution(int[] numbers, int target) {
        
        Solution.numbers = numbers;
        Solution.target = target;
        Solution.maxIndex = numbers.length;
        dfs(0,false,0);
        dfs(0,true,0);
      
        return ans/2;
    }
    
    public void dfs(int index, boolean flag, int sum){
        if(index == maxIndex){
            if(sum == target){
                
                ans ++;
            }
            //System.out.println(sum);
            return;
        }
        int number = flag ? numbers[index] : -numbers[index];
        //System.out.println(number);
        sum += number;
        dfs(index+1,true,sum);
        dfs(index+1,false,sum);
    }
}