class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int[] row : memo) Arrays.fill(row , -1);

        return dfs(0 , false , prices , memo);
    }
    private int dfs(int i , boolean buy , int[] prices , int[][] memo){
        if(i >= prices.length) return 0;
        int col = (buy == true) ? 1 : 0;
        if(memo[i][col] != -1) return memo[i][col];

        return memo[i][col] = (buy == true) ?
        Math.max(prices[i] + dfs(i + 2 , false , prices , memo) , dfs(i + 1 , true , prices , memo)) : 
        Math.max(-prices[i] + dfs(i + 1 , true , prices , memo) , dfs(i + 1 , false , prices , memo));
    }
}