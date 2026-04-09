class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums); // 1 2 2 3 4
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) return nums[i];
        }
        return nums[0];
    }
}