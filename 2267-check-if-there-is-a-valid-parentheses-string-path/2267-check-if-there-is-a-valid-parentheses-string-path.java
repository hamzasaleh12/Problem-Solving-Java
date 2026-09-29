class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length , n = grid[0].length;
        if(grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        return dfs(0 , 0 , 0 , grid , new Boolean[m][n][1005]); // 10^2 * 10^2 * 10^3 -> 10^7
    }
    private boolean dfs(int i , int j , int count , char[][] grid , Boolean[][][] dp){
        if(i == grid.length - 1 && j == grid[0].length - 1) return count == 1;
        if(i >= grid.length || j >= grid[0].length || count < 0) return false;

        if(dp[i][j][count] != null){
            return dp[i][j][count];
        }
        
        int newCount = (grid[i][j] == '(') ? count + 1 : count - 1;

        return dp[i][j][count] = dfs(i , j + 1 , newCount , grid , dp) || dfs(i + 1 , j , newCount , grid , dp);
    }
}