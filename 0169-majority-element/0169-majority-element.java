class Solution {
    public int majorityElement(int[] nums) {
        int curr = 0 , count = 0;
        for(int num : nums){
            if(count == 0) curr = num;

            if(curr == num) count++;
            else count--;
        }
        return curr;
    }
}