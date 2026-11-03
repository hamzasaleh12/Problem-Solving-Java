class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE; // or 0
        for(int num : nums) max = Math.max(max , num);

        int minMoves = 0;
        for(int num : nums){
            minMoves += max - num;
        }

        return minMoves;
    }
}