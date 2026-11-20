import java.util.Arrays;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        
        int maxVal = nums[nums.length - 1];
        // dp[v] = أطول سلسلة متتالية تنتهي عند الرقم v
        int[] dp = new int[maxVal + 2];
        int maxLen = 0;

        for (int x : nums) {
            // لازم نحسب x + 1 الأول قبل تعديل dp[x] عشان منعدش نفس العنصر مرتين
            dp[x + 1] = dp[x] + 1;
            dp[x] = dp[x - 1] + 1;

            maxLen = Math.max(maxLen, Math.max(dp[x], dp[x + 1]));
        }

        return maxLen;
    }
}