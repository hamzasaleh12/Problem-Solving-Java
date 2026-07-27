class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        Arrays.sort(coins);
        int n = coins.length;

        Long[][] memo = new Long[n][amount + 1];

        long sol = dfs(0 , coins , amount , memo);
        return sol >= Integer.MAX_VALUE ? -1 : (int) sol;
    }
    private long dfs(int i , int[] coins , int rem , Long[][] memo){ // 
        if(rem == 0) return 0;
        if(i >= coins.length || rem < 0) return Integer.MAX_VALUE;
        if(memo[i][rem] != null) return memo[i][rem];

        return memo[i][rem] = Math.min(1 + dfs(i , coins , rem - coins[i] , memo) , dfs(i + 1 , coins , rem , memo));
    }
}