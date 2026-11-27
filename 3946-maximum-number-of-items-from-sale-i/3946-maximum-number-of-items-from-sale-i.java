class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] gain = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            gain[i] = 1;
            minPrice = Math.min(minPrice, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int g = gain[i];

            for (int m = budget; m >= price; m--) {
                if (dp[m - price] != -1) {
                    dp[m] = Math.max(dp[m], dp[m - price] + g);
                }
            }
        }

        int ans = 0;
        for (int m = 0; m <= budget; m++) {
            if (dp[m] != -1) {
                int remainingMoney = budget - m;
                int extraCopies = remainingMoney / minPrice;
                ans = Math.max(ans, dp[m] + extraCopies);
            }
        }

        return ans;
    }
}