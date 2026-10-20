class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && isSortable(nums, k, n)) {
                sum += k;
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int k, int n) {
        int prevMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i += k) {
            int blockMin = Integer.MAX_VALUE;
            int blockMax = Integer.MIN_VALUE;
            int drops = 0;

            for (int j = 0; j < k; j++) {
                int curr = nums[i + j];
                int next = nums[i + (j + 1) % k];

                if (curr > next) {
                    drops++;
                }

                blockMin = Math.min(blockMin, curr);
                blockMax = Math.max(blockMax, curr);
            }

            if (drops > 1) {
                return false;
            }

            if (prevMax > blockMin) {
                return false;
            }

            prevMax = blockMax;
        }

        return true;
    }
}