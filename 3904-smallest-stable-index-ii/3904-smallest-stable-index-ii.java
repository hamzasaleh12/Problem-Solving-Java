class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] max = new int[n];

        max[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            max[i] = Math.max(max[i - 1] , nums[i]);
        }

        for(int i = n - 2 ; i >= 0 ; i--){
            nums[i] = Math.min(nums[i + 1] , nums[i]);
        }

        for(int i = 0 ; i < n ; i++){
            if(max[i] - nums[i] <= k) return i;
        }

        return -1;
    }
}