class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = nums[0] , currMin = 0;
        int max = nums[0] , currMAX = 0;
        int total = 0;

        for(int num : nums){
            currMAX = Math.max(currMAX + num , num);
            max = Math.max(max , currMAX);

            currMin = Math.min(currMin + num , num);
            min = Math.min(min , currMin);

            total += num;
        }

        return (max < 0) ? max : Math.max(max , total - min);
    }
}