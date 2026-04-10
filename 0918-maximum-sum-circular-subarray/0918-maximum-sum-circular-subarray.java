class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = nums[0] , currMin = 0;
        int max = nums[0] , currMax = 0;
        int total = 0;

        for(int num : nums){
            currMax = Math.max(currMax + num , num);
            max = Math.max(max , currMax);

            currMin = Math.min(currMin + num , num);
            min = Math.min(min , currMin);

            total += num;
        }

        return (max < 0) ? max : Math.max(max , total - min);
    }
}