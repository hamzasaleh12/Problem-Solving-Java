class Solution {
    private static final long BASE = 131L;
    private static final long MOD = 1_000_000_007L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;
        int answer = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasUniqueSubarrayOfLength(nums, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean hasUniqueSubarrayOfLength(int[] nums, int len) {
        int n = nums.length;
        if (len > n) return false;

        long power = 1;
        for (int i = 0; i < len - 1; i++) {
            power = (power * BASE) % MOD;
        }

        long hash = 0;
        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i >= len) {
                long outVal = ((nums[i - len] % MOD) + MOD) % MOD;
                hash = (hash - (outVal * power) % MOD + MOD) % MOD;
            }

            long inVal = ((nums[i] % MOD) + MOD) % MOD;
            hash = (hash * BASE + inVal) % MOD;

            if (i >= len - 1) {
                freq.put(hash, freq.getOrDefault(hash, 0) + 1);
            }
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}