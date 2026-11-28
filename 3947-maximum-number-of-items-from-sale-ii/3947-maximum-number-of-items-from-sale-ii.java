class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] divCount = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            for (int multiple = f; multiple <= n; multiple += f) {
                divCount[f] += freq[multiple];
            }
            divCount[f]--;
        }

        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = items[i][1];
            sorted[i][1] = divCount[items[i][0]];
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        long rem = budget;
        long ans = 0;
        long minPrice = sorted[0][0];

        for (int i = 0; i < n; i++) {
            long price = sorted[i][0];
            long k = sorted[i][1];

            if (price >= 2 * minPrice) break;
            if (k == 0 || rem < price) continue;

            long take = Math.min(k, rem / price);
            ans += take * 2;
            rem -= take * price;
        }

        ans += rem / minPrice;

        return (int) ans;
    }
}