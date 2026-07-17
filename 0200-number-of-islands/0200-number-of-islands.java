class Solution {
    private static int[][] drs = {{0,1} , {1,0} , {-1 , 0} , {0 , -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid , i , j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid , int row , int col){
        if(row == grid.length || row < 0 || col == grid[0].length || col < 0 || grid[row][col] == '0') return; // base case
        for(int[] d : drs){
            grid[row][col] = '0';
            dfs(grid , row + d[0] , col + d[1]);
        }
    }
}