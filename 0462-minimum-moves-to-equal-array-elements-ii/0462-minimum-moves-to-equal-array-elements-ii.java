class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        return ((n & 1) == 0) ? Math.min(minMoves(nums , nums[(n - 1) / 2]) , minMoves(nums , nums[n / 2])) : minMoves(nums , nums[n / 2]);
    }
    public int minMoves(int[] nums , int base) {
        int minMoves = 0;

        for(int num : nums){
            if(base <= num){
                minMoves += num - base;
            } else{
                minMoves += base - num;
            }
        }

        return minMoves;
    }
}