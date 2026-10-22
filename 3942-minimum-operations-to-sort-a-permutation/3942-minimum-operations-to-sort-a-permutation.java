class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int idx0 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }

        int incDrops = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] + 1 != nums[(i + 1) % n]) {
                incDrops++;
            }
        }
        if (incDrops == 1) {
            return Math.min(idx0, 2 + n - idx0);
        }

        int decDrops = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != nums[(i + 1) % n]) {
                decDrops++;
            }
        }
        if (decDrops == 1) {
            return Math.min(idx0 + 2, n - idx0);
        }

        return -1;
    }
}