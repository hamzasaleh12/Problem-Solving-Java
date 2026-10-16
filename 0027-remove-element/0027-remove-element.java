class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int right = 0 ; right < nums.length ; right++){
            if(nums[right] != val){
                nums[k++] = nums[right];
            }
        }
        return k;
    }
}