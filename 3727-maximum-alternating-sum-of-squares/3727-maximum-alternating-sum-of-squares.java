class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] freq = new int[40005];

        for (int x : nums) {
            freq[Math.abs(x)]++;
        }

        int left = 0;
        int right = 40000;
        long sum = 0;

        for (int p = 0; p < n / 2; p++) {
            while (freq[left] == 0) left++;
            while (freq[right] == 0) right--;

            sum += (long) right * right - (long) left * left;
            freq[left]--;
            freq[right]--;
        }

        if ((n & 1) == 1) {
            while (freq[right] == 0) right--;
            sum += (long) right * right;
        }

        return sum;
    }
}