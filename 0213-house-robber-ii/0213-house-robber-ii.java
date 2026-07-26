class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] maxRobs1 = new int[n];
        Arrays.fill(maxRobs1 , -1);
        
        int[] maxRobs2 = new int[n];
        Arrays.fill(maxRobs2 , -1);

        int range1 = Math.max(dfs(0, nums, maxRobs1, n - 1), 
                              dfs(1, nums, maxRobs1, n - 1));

        int range2 = Math.max(dfs(1, nums, maxRobs2, n), 
                              dfs(2, nums, maxRobs2, n));

        return Math.max(range1, range2);
    }
    private int dfs(int start , int[] nums , int[] maxRobs , int length){
        if(start >= length) return 0;
        if(maxRobs[start] != -1) return maxRobs[start];

        return maxRobs[start] = nums[start] + Math.max(dfs(start + 2 , nums , maxRobs , length) , dfs(start + 3 , nums , maxRobs , length));
    }
}