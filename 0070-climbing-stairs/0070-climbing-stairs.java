class Solution {
    public int climbStairs(int n) {
        int[] count = {0};

        int[] arr = new int[n + 1];
        Arrays.fill(arr , -1);

        return dfs(0 , n , arr);
    }
    private int dfs(int sum , int n , int[] arr){
        if(sum == n) return 1;
        if(sum > n) return 0;

        if(arr[sum] != -1) return arr[sum];

        return arr[sum] = dfs(sum + 1 , n , arr) + dfs(sum + 2 , n , arr);
    }
}