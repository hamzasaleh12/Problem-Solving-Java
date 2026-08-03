class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1; arr[n + 1] = 1;

        for(int i = 0 ; i < n ; i++){
            arr[i + 1] = nums[i];
        }

        return dfs(1 , n , arr , new int[n + 2][n + 2]);
    }
    private int dfs(int L , int R , int[] nums , int[][] memo){
        if(L > R) return 0;
        if(memo[L][R] != 0) return memo[L][R];

        int maxCoins = 0;
        for(int k = L ; k <= R ; k++){
           int currCoins = dfs(L , k - 1 , nums , memo) + dfs(k + 1 , R , nums , memo) + nums[L - 1] * nums[k] * nums[R + 1];
           maxCoins = Math.max(maxCoins , currCoins);
        }

        return memo[L][R] = maxCoins;
    }
}