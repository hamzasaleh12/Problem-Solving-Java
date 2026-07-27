class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;

        if((sum & 1) == 1) return false;

        return dfs(0 , 0 , sum / 2 , nums , new Boolean[nums.length][sum / 2 + 1]);
    }
    private boolean dfs(int i , int sum , int tar , int[] nums , Boolean[][] memo){
        if(i >= nums.length || sum > tar) return false;
        if(sum == tar) return true;
        if(memo[i][sum] != null) return memo[i][sum];

        return memo[i][sum] = dfs(i + 1 , sum + nums[i] , tar , nums , memo) || dfs(i + 1 , sum , tar , nums , memo);
    }
}