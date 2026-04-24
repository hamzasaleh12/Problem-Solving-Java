class Solution {
    private static final int[][] drs = {{0,1} , {0,-1} , {1,0} , {-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int max = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max , dfs(i , j , grid));
                }
            }
        }

        return max;
    }
    private int dfs(int r , int c , int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
        grid[r][c] = 0;

        int area = 1;
        for(int i = 0; i < 4 ; i++){
            area += dfs(r + drs[i][0] , c + drs[i][1] , grid);
        }
        
        return area;
    }
}