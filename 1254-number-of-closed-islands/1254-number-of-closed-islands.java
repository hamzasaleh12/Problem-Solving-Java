class Solution {
    int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};

    public int closedIsland(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(dfs(i , j , grid , visited)) res++;
                }
            }
        }

        return res;
    }
    private boolean dfs(int i , int j , int[][] grid , boolean[][] visited){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) return false;
        if(grid[i][j] == 0 && (i == grid.length -1 || i == 0 || j == grid[0].length - 1 || j == 0)) return false;
        if(visited[i][j] || grid[i][j] == 1) return true;

        visited[i][j] = true;
        boolean isClosed = true;

        for (int[] d : drs) {
            if (!dfs(i + d[0], j + d[1], grid, visited)) {
                isClosed = false;
            }
        }

        return isClosed;
    }
}