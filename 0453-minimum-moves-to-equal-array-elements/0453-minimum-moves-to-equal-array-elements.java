class Solution {
    public int minMoves(int[] nums) {
        int minMoves = 0;

        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min , num);
        }

        for(int num : nums){
            minMoves += num - min;
        }

        return minMoves;
    }
}