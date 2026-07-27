class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMin = nums[0];
        int currMax = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            int num = nums[i];

            int temp = currMax;
            currMax = Math.max(num , Math.max(num * currMin , num * currMax));
            currMin = Math.min(num , Math.min(num * currMin , num * temp)); // 3 , -6 , -4

            max = Math.max(max , Math.max(currMax , currMin)); // 6
        }
        
        return max;
    }
}