class Solution {
    private static final int[][] dcs = {{1,0} , {0,1} , {-1,0} , {0,-1}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int islands = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == '1'){
                    dfs(i , j , grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(int r , int c , char[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        for(int i = 0 ; i < 4 ; i++){
            dfs(r + dcs[i][0] , c + dcs[i][1] , grid);
        }
    }
}