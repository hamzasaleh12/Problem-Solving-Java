class Solution {
    public int minIncrementForUnique(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int count = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] <= nums[i - 1]){
                int val = nums[i - 1] + 1; // tar

                count += (val - nums[i]); // dis

                nums[i] = val; // update
            }
        }
        return count;
    }
}