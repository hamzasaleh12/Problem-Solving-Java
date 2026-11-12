class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        // Option 1: Buy everything separately (x = 0)
        long allSeparate = n1 * c1 + n2 * c2;

        // Option 2: Cover the smaller requirement using Type 3, and the rest separately
        long minNeed = Math.min(n1, n2);
        long mixed = minNeed * cb + (n1 - minNeed) * c1 + (n2 - minNeed) * c2;

        // Option 3: Cover both requirements entirely using Type 3 (even if there is surplus)
        long maxNeed = Math.max(n1, n2);
        long allBoth = maxNeed * cb;

        return Math.min(allSeparate, Math.min(mixed, allBoth));
    }
}