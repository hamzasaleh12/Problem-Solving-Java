class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length + 1];
        for(int[] row : memo) Arrays.fill(row , -1);

        return dfs(0, nums, -1, memo);
    }
    private int dfs(int i , int[] nums , int prev , int[][] memo){
        if(i >= nums.length) return 0;
        if(memo[i][prev + 1] != -1) return memo[i][prev + 1];

        return memo[i][prev + 1] = (prev == -1 || nums[i] > nums[prev]) ? Math.max(1 + dfs(i + 1 , nums , i , memo) , dfs(i + 1 , nums , prev , memo)) : dfs(i + 1 , nums , prev , memo);
    }
}