class Solution {
    private static final int[][] drs = {{1,0} , {0,1} , {-1,0} , {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int i = 0 ; i < rows ; i++){
            dfs(i , 0 , heights[i][0] , heights , pac);
            dfs(i , cols - 1 , heights[i][cols - 1] , heights , atl);
        }
        for(int i = 0 ; i < cols ; i++){
            dfs(0 , i , heights[0][i] , heights , pac);
            dfs(rows - 1 , i , heights[rows - 1][i] , heights , atl);
        }

        for(int i = 0; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(pac[i][j] && atl[i][j]) result.add(List.of(i,j));
            }
        }

        return result;
    }
    private void dfs(int row , int col , int curr , int[][] heights , boolean[][] visited){
        if(row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || 
        visited[row][col] || heights[row][col] < curr) return;

        visited[row][col] = true;
        for(int[] d : drs){
            dfs(row + d[0] , col + d[1] , heights[row][col] , heights , visited);
        }
    }
}