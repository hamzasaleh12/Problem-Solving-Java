class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++) memo[i][j] = -1;
        }
        return dfs(m - 1 , 0 , m , n , memo);
    }
    private int dfs(int r , int c , int m , int n , int[][] memo){
        if(r == 0 && c == n - 1) return 1;
        if(c >= n || r < 0) return 0;
        if(memo[r][c] != -1) return memo[r][c];

        return memo[r][c] = dfs(r - 1 , c , m , n , memo) + dfs(r , c + 1 , m , n , memo);
    }
}