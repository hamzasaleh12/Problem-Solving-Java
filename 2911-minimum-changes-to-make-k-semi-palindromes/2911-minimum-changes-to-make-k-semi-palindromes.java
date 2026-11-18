class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int[] row : cost) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                cost[i][j] = getMinCost(s, i, j, len);
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int parts = 1; parts <= k; parts++) {
                for (int start = 0; start <= i - 2; start++) {
                    dp[i][parts] = Math.min(dp[i][parts], dp[start][parts - 1] + cost[start][i - 1]);
                }
            }
        }

        return dp[n][k];
    }

    private int getMinCost(String s, int start, int end, int len) {
        int minCost = Integer.MAX_VALUE;
        
        for (int d = 1; d < len; d++) {
            if (len % d == 0) {
                int currentCost = 0;
                
                for (int offset = 0; offset < d; offset++) {
                    int l = start + offset;
                    int r = start + offset + ((len / d) - 1) * d;
                    
                    while (l < r) {
                        if (s.charAt(l) != s.charAt(r)) {
                            currentCost++;
                        }
                        l += d;
                        r -= d;
                    }
                }
                minCost = Math.min(minCost, currentCost);
            }
        }
        return minCost;
    }
}