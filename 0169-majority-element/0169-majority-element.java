class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int count = 0;
        for(int num : nums){
            if(num == curr){
                count++;
            } else{
                count--;
            }

            if(count < 0){
                curr = num;
                count = 0;
            }
        }
        return curr;
    }
}