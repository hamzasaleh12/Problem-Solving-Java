class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int totalSum = 0;
        int min = nums[0];
        for(int num : nums) {
            totalSum += num; // 11
            min = Math.min(min , num); // 1
        }

        int tar = totalSum - x; // 6
        if(tar < 0 || x > totalSum || min > x) return -1;

        // (Reverse Eng)
        // we want the maximum length of subArray the sum of it = totalSum - x;
        int left = 0;
        long sum = 0;
        int maxLength = -1;
        for(int right = 0 ; right < n ; right++){
            sum += nums[right];

            while(sum > tar){
                sum -= nums[left++];
            }

            if(sum == tar){
                maxLength = Math.max(maxLength , right - left + 1);
            }
        }

        return (maxLength == -1) ? -1 : n - maxLength;
    }
}