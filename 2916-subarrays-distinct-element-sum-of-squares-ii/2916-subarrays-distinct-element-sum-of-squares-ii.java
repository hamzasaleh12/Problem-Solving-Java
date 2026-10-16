class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] treeSum;
    private long[] treeSq;
    private long[] lazy;

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        long term1 = (2 * val % MOD) * (treeSum[node] % MOD) % MOD;
        long term2 = ((len * val) % MOD) * (val % MOD) % MOD;
        treeSq[node] = (treeSq[node] + term1 + term2) % MOD;

        treeSum[node] = (treeSum[node] + (len * val) % MOD) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }

        push(node, l, r);
        int mid = l + (r - l) / 2;
        if (ql <= mid) {
            update(2 * node, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update(2 * node + 1, mid + 1, r, ql, qr, val);
        }
        treeSum[node] = (treeSum[2 * node] + treeSum[2 * node + 1]) % MOD;
        treeSq[node] = (treeSq[2 * node] + treeSq[2 * node + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        treeSum = new long[4 * n];
        treeSq = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);

        long totalAns = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = lastPos[x] + 1;

            update(1, 0, n - 1, prev, i, 1);

            totalAns = (totalAns + treeSq[1]) % MOD;
            lastPos[x] = i;
        }

        return (int) totalAns;
    }
}