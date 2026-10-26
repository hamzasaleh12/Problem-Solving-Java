class Solution {
    private int[][] drs ={{0,1} , {1,0} , {-1,0} , {0,-1}};
    public int countIslands(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length;

        int res = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0){
                    if((dfs(i , j , grid) % k) == 0) res++;
                }
            }
        }

        return res;
    }
    private long dfs(int i , int j , int[][] grid){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) return 0;

        long sum = grid[i][j];
        grid[i][j] = 0;
        for(int[] d : drs){
            sum += dfs(i + d[0] , j + d[1] , grid);
        }

        return sum;
    }
}