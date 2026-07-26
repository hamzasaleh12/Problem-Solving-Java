class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] maxRobs = new int[n];
        Arrays.fill(maxRobs , -1);

        return dfs(0 , nums , maxRobs);
    }
    private int dfs(int start , int[] nums , int[] maxRobs){
        if(start >= nums.length) return 0;
        if(maxRobs[start] != -1) return maxRobs[start];

        return maxRobs[start] = Math.max(nums[start] + dfs(start + 2 , nums , maxRobs) , dfs(start + 1 , nums , maxRobs));
    }
}