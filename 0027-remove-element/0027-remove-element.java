class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int left = 0; 
        for(int right = 0 ; right < nums.length ; right++){
            if(nums[right] != val) k++;

            while(left < right && nums[left] != val) left++;
            // swap
            if(nums[right] != val && left < right){
                int t = nums[right];
                nums[right] = nums[left];
                nums[left] = t;
            }
        }

        return k;
    }
}