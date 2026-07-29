class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for(int[] row : memo) Arrays.fill(row , -1);

        return dfs(0 , 0 , coins , amount , memo);
    }
    private int dfs(int i , int sum , int[] coins , int amount , int[][] memo){
        if(sum == amount) return 1;
        if(sum > amount || i >= coins.length) return 0;
        if(memo[i][sum] != -1) return memo[i][sum];

        return memo[i][sum] = dfs(i , sum + coins[i] , coins , amount , memo) + dfs(i + 1 , sum , coins , amount , memo);
    }
}