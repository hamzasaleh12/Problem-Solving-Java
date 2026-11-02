class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int minMoves = 0;
        int i = 0, j = nums.length - 1;
        
        while (i < j) {
            minMoves += nums[j] - nums[i];
            i++;
            j--;
        }
        
        return minMoves;
    }
}