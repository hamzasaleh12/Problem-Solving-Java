class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        Arrays.fill(minCost , -1);

        return Math.min(dfs(0 , cost , minCost) , dfs(1 , cost , minCost));
    }
    private int dfs(int i , int[] cost , int[] minCost){
        if(i >= cost.length) return 0;
        if(minCost[i] != -1) return minCost[i];

        return minCost[i] = cost[i] + Math.min(dfs(i + 1 , cost , minCost) , dfs(i + 2 , cost , minCost));
    }
}