class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int oddCount = 0;
        int evenCount = 1;
        int currentSum = 0;
        long totalSubarrays = 0;

        for (int num : arr) {
            currentSum += num;
            
            if ((currentSum & 1) == 1) { // odd
                totalSubarrays += evenCount;
                oddCount++;
            } else { // even
                totalSubarrays += oddCount;
                evenCount++;
            }
            
            totalSubarrays %= MOD;
        }

        return (int) totalSubarrays;
    }
}