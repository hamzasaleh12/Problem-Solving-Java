class Solution {
    static class WindowMedianTracker {
        private final TreeMap<Integer, Integer> left = new TreeMap<>();
        private final TreeMap<Integer, Integer> right = new TreeMap<>();
        private int leftSize = 0, rightSize = 0;
        private long leftSum = 0, rightSum = 0;
        private final int x;
        private final int targetLeft;

        public WindowMedianTracker(int x) {
            this.x = x;
            this.targetLeft = (x + 1) / 2;
        }

        private void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        private void removeMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        public void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                addMap(left, val);
                leftSum += val;
                leftSize++;
            } else {
                addMap(right, val);
                rightSum += val;
                rightSize++;
            }
            rebalance();
        }

        public void remove(int val) {
            if (!left.isEmpty() && val <= left.lastKey()) {
                removeMap(left, val);
                leftSum -= val;
                leftSize--;
            } else {
                removeMap(right, val);
                rightSum -= val;
                rightSize--;
            }
            rebalance();
        }

        private void rebalance() {
            while (leftSize > targetLeft) {
                int maxLeft = left.lastKey();
                removeMap(left, maxLeft);
                leftSum -= maxLeft;
                leftSize--;

                addMap(right, maxLeft);
                rightSum += maxLeft;
                rightSize++;
            }
            while (leftSize < targetLeft && rightSize > 0) {
                int minRight = right.firstKey();
                removeMap(right, minRight);
                rightSum -= minRight;
                rightSize--;

                addMap(left, minRight);
                leftSum += minRight;
                leftSize++;
            }
        }

        public long getCost() {
            if (x % 2 == 1) {
                return rightSum - leftSum + left.lastKey();
            } else {
                return rightSum - leftSum;
            }
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] costs = new long[n];
        WindowMedianTracker tracker = new WindowMedianTracker(x);

        // تجهيز أول x - 1 عناصر
        for (int i = 0; i < x - 1; i++) {
            tracker.add(nums[i]);
        }

        for (int i = x - 1; i < n; i++) {
            tracker.add(nums[i]);
            costs[i] = tracker.getCost();
            tracker.remove(nums[i - x + 1]);
        }

        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = x; i <= n; i++) {
            long currentCost = costs[i - 1];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + currentCost);
                }
            }
        }

        return dp[n][k];
    }
}