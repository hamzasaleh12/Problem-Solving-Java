class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[nums.length][2001];
        for(int[] row : memo) Arrays.fill(row , -1);
        return dfs(0 , 0 , nums , target , memo);
    }
    private int dfs(int i , int sum , int[] nums , int tar , int[][] memo){
        if(i == nums.length){
            return (sum == tar) ? 1 : 0;
        }
        if(memo[i][sum + 1000] != -1) return memo[i][sum + 1000];

        return memo[i][sum + 1000] = dfs(i + 1 , sum + nums[i] , nums , tar , memo) + dfs(i + 1 , sum - nums[i] , nums , tar , memo);
    }
}