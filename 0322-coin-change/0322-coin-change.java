class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        
        int res = dfs(amount, coins, memo);
        
        return res >= 1e9 ? -1 : res;
    }

    private int dfs(int rem, int[] coins, int[] memo) {
        if (rem == 0) return 0;
        if (rem < 0) return (int) 1e9;
        if (memo[rem] != -1) return memo[rem];

        int minCoins = (int) 1e9;
        for (int coin : coins) {
            minCoins = Math.min(minCoins, 1 + dfs(rem - coin, coins, memo));
        }

        return memo[rem] = minCoins;
    }
}