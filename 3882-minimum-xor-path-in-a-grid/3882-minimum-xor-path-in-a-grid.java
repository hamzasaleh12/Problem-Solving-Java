class Solution {
    int[] min = {Integer.MAX_VALUE};
    public int minCost(int[][] grid) {
        dfs(0 , 0 , grid , new boolean[grid.length][grid[0].length][1 << 10] , grid[0][0]);
        return min[0];
    }
    private void dfs(int i , int j , int[][] grid , boolean[][][] dp , int res){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            min[0] = Math.min(min[0] , res);
            return;
        }
        if(dp[i][j][res]){
            return;
        }
        dp[i][j][res] = true;

        if(j + 1 < grid[0].length) {
            int newRes = res ^ grid[i][j + 1];
            dfs(i , j + 1 , grid , dp , newRes);
        }
        if(i + 1 < grid.length) {
            int newRes = res ^ grid[i + 1][j];
            dfs(i + 1 , j , grid , dp , newRes);
        }
    }
}