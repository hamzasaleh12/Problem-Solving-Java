class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int[] sortedNums = new int[n];
        for(int i = 0 ; i < n ; i++) sortedNums[i] = nums[i];
        Arrays.sort(sortedNums);

        int k = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != sortedNums[i]){
                k &= nums[i] & sortedNums[i];
            }
        }

        return (k == Integer.MAX_VALUE) ? 0 : k;
    }
}