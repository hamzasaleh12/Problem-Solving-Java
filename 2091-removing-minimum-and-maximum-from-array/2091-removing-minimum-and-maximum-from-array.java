class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int first = Math.min(minIdx, maxIdx);
        int second = Math.max(minIdx, maxIdx);

        int removeBothFromLeft = second + 1;
        int removeBothFromRight = n - first;
        int removeFromBothSides = (first + 1) + (n - second);

        return Math.min(removeBothFromLeft, Math.min(removeBothFromRight, removeFromBothSides));
    }
}