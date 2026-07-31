class Solution {
    private static final int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int[][] memo = new int[m][n];
        for(int[] row : memo) Arrays.fill(row , -1);

        int max = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                max = Math.max(max , dfs(i , j , matrix , memo , -1));
            }
        }

        return max;
    }
    private int dfs(int i , int j , int[][] matrix , int[][] memo , int prev){
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || prev >= matrix[i][j]) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int max = 1;
        for(int[] d : drs){
            max = Math.max(max , 1 + dfs(i + d[0], j + d[1], matrix , memo, matrix[i][j]));
        }
        
        return memo[i][j] = max;
    }
}