class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // x = nC - y
        slow = 0;
        while(nums[slow] != nums[fast]){
            slow = nums[slow]; // x
            fast = nums[fast]; // nC - y
        }
        return nums[slow];
    }
}