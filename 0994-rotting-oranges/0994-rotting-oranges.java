class Solution {
    private final static int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        int oranges = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) oranges++;
                else if(grid[i][j] == 2) queue.add(new int[]{i,j}); // [0,0]
            }
        }
        
        int[] rottenOrange = {0};
        int count = -1;
        while(!queue.isEmpty()){
            int levelSize = queue.size(); // 1
            count++; // 4
            for(int i = 0 ; i < levelSize ; i++){
                int[] curr = queue.poll(); // [0,0]
                for(int[] d : drs){
                    dfs(curr[0] + d[0] , curr[1] + d[1] , grid , queue , rottenOrange);
                    // right , left , up , down -> change any 1 to 2 and add it to queue
                }
            }
        }
        return (rottenOrange[0] == oranges) ? Math.max(0,count) : -1;
    }
    private void dfs(int r , int c , int[][] grid , ArrayDeque<int[]> queue , int[] rottenOrange){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) return;
        grid[r][c] = 2;
        rottenOrange[0]++;
        queue.add(new int[]{r , c});
    }
}