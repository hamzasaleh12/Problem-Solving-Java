class Solution {
    private static int[][] drs = {{0,1} , {1,0} , {-1 , 0} , {0 , -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max , dfs(grid , i , j));
                }
            }
        }

        return max;
    }
    private int dfs(int[][] grid , int row , int col){
        if(row == grid.length || row < 0 || col == grid[0].length || col < 0 || grid[row][col] == 0) return 0; // base case
        grid[row][col] = 0;
        
        int area = 1;
        for(int[] d : drs){
            area += dfs(grid , row + d[0] , col + d[1]);
        }

        return area;
    }
}