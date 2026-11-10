class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(0, n, costs, memo);
    }

    private int solve(int i, int n, int[] costs, int[] memo) {
        if (i == n) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int minCost = Integer.MAX_VALUE;

        for (int jump = 1; jump <= 3; jump++) {
            int nextStep = i + jump;
            if (nextStep <= n) {
                int jumpCost = costs[nextStep - 1] + (jump * jump);
                int totalCost = jumpCost + solve(nextStep, n, costs, memo);
                minCost = Math.min(minCost, totalCost);
            }
        }

        return memo[i] = minCost;
    }
}