class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 1 && n == 1) return 1;
        if (grid[m - 1][n - 1] == 1) return 0;

        int MOD = 1_000_000_007;
        // dp[i][j][0] -> Paths leaving (i, j) to the Right
        // dp[i][j][1] -> Paths leaving (i, j) to the Down
        int[][][] dp = new int[m][n][2];

        dp[0][0][0] = 1; 
        dp[0][0][1] = 1; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int inR = (j > 0) ? dp[i][j - 1][0] : 0;
                int inD = (i > 0) ? dp[i - 1][j][1] : 0;

                if (grid[i][j] == 0) {
                    dp[i][j][0] = (inR + inD) % MOD;
                    dp[i][j][1] = (inR + inD) % MOD;
                } else {
                    dp[i][j][0] = inD;
                    dp[i][j][1] = inR;
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}