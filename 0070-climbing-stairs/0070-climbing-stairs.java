class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[n] = 1 ; arr[n - 1] = 1;
        for(int i = n - 2 ; i >= 0 ; i--){
            arr[i] = arr[i + 1] + arr[i + 2];
        }
        return arr[0];
    }
    private int dfs(int sum , int n , int[] arr){
        if(sum == n) return 1;
        if(sum > n) return 0;

        if(arr[sum] != 0) return arr[sum];

        return arr[sum] = dfs(sum + 1 , n , arr) + dfs(sum + 2 , n , arr);
    }
}