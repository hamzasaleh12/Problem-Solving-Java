class Solution {

    static class Node {
        int totalProd;
        int[] count;

        Node(int k) {
            this.count = new int[k];
        }
    }

    private Node[] tree;

    private Node merge(Node left, Node right, int k) {
        Node res = new Node(k);
        res.totalProd = (left.totalProd * right.totalProd) % k;

        for (int r = 0; r < k; r++) {
            res.count[r] += left.count[r];
        }

        for (int r = 0; r < k; r++) {
            if (right.count[r] > 0) {
                int newRem = (left.totalProd * r) % k;
                res.count[newRem] += right.count[r];
            }
        }

        return res;
    }

    private void build(int treeIdx, int l, int r, int[] nums, int k) {
        tree[treeIdx] = new Node(k);
        if (l == r) {
            int rem = nums[l] % k;
            tree[treeIdx].totalProd = rem;
            tree[treeIdx].count[rem] = 1;
            return;
        }

        int mid = l + (r - l) / 2;
        build(2 * treeIdx, l, mid, nums, k);
        build(2 * treeIdx + 1, mid + 1, r, nums, k);

        tree[treeIdx] = merge(tree[2 * treeIdx], tree[2 * treeIdx + 1], k);
    }

    private void update(int treeIdx, int l, int r, int idx, int val, int k) {
        if (l == r) {
            int rem = val % k;
            tree[treeIdx].totalProd = rem;
            Arrays.fill(tree[treeIdx].count, 0);
            tree[treeIdx].count[rem] = 1;
            return;
        }

        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * treeIdx, l, mid, idx, val, k);
        } else {
            update(2 * treeIdx + 1, mid + 1, r, idx, val, k);
        }

        tree[treeIdx] = merge(tree[2 * treeIdx], tree[2 * treeIdx + 1], k);
    }

    private Node query(int treeIdx, int l, int r, int ql, int qr, int k) {
        if (ql <= l && r <= qr) {
            return tree[treeIdx];
        }

        int mid = l + (r - l) / 2;
        if (qr <= mid) {
            return query(2 * treeIdx, l, mid, ql, qr, k);
        }
        if (ql > mid) {
            return query(2 * treeIdx + 1, mid + 1, r, ql, qr, k);
        }

        Node leftRes = query(2 * treeIdx, l, mid, ql, qr, k);
        Node rightRes = query(2 * treeIdx + 1, mid + 1, r, ql, qr, k);
        return merge(leftRes, rightRes, k);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1, nums, k);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val, k);

            Node qRes = query(1, 0, n - 1, start, n - 1, k);

            ans[i] = qRes.count[x];
        }

        return ans;
    }
}