class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] maxRobs = new int[nums.length];
        Arrays.fill(maxRobs , -1);

        return Math.max(dfs(0 , nums , maxRobs) , dfs(1 , nums , maxRobs));
    }
    private int dfs(int start , int[] nums , int[] maxRobs){
        if(start >= nums.length) return 0;
        if(maxRobs[start] != -1) return maxRobs[start];

        return maxRobs[start] = nums[start] + Math.max(dfs(start + 2 , nums , maxRobs) , dfs(start + 3 , nums , maxRobs));
    }
}