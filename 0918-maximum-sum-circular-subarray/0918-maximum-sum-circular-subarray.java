class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curr = nums[0];
        int max = nums[0];

        int total = 0;
        for(int num : nums){
            total += num;
        }

        int min = nums[0];
        for(int i = 1; i < nums.length ; i++){
            curr = Math.min(curr + nums[i] , nums[i]);
            min = Math.min(min , curr); // -2
        }

        curr = nums[0];
        for(int i = 1; i < nums.length ; i++){
            curr = Math.max(curr + nums[i] , nums[i]);
            max = Math.max(max , curr);
        }

        return (max < 0) ? max : Math.max(max , total - min);
    }
}