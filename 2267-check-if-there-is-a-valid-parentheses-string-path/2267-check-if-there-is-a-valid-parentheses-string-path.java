class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length , n = grid[0].length;
        int pathLength = m + n - 1;
        if(grid[0][0] == ')' || grid[m - 1][n - 1] == '(' || (pathLength & 1) != 0) return false;

        return dfs(0 , 0 , 0 , grid , new int[m][n][m + n]); // 10^2 * 10^2 * 10*2-> 10^6
    }
    private boolean dfs(int i , int j , int count , char[][] grid , int[][][] dp){
        if(i == grid.length - 1 && j == grid[0].length - 1) return count == 1;
        if(i >= grid.length || j >= grid[0].length || count < 0) return false;

        if(dp[i][j][count] != 0){
            return dp[i][j][count] == 2;
        }
        
        int newCount = (grid[i][j] == '(') ? count + 1 : count - 1;

        boolean isValid = dfs(i , j + 1 , newCount , grid , dp) || dfs(i + 1 , j , newCount , grid , dp);
        dp[i][j][count] = (isValid) ? 2 : 1;

        return isValid;
    }
}