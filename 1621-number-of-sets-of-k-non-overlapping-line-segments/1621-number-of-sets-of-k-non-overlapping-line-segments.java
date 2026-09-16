class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][][] memo;
    private int n;

    public int numberOfSets(int n, int k) {
        this.n = n;
        this.memo = new Integer[n][k + 1][2];
        return solve(0, k, 0);
    }

    private int solve(int i, int k, int isOpened) {
        if (k < 0) return 0;
        if (i == n - 1) return k == 0 ? 1 : 0;

        if (memo[i][k][isOpened] != null) {
            return memo[i][k][isOpened];
        }

        if (isOpened == 1) {
            return memo[i][k][isOpened] = (int) (
                ((long) solve(i + 1, k, 1)          // expand
                      + solve(i + 1, k, 0)          // close the line
                      + solve(i + 1, k - 1, 1)      // close the old line and open another one
                ) % MOD
            );
        } else {
            return memo[i][k][isOpened] = (int) (
                ((long) solve(i + 1, k - 1, 1)      // open
                      + solve(i + 1, k, 0)          // skip
                ) % MOD
            );
        }
    }
}