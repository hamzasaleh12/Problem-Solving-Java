class Solution {
    private static final int[][] drs = {{1,0} , {0,1} , {-1,0} , {0,-1}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int freshOrange = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[] {i , j});
                } else if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }

        if(freshOrange == 0) return 0;

        int mins = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRottin = false;

            for(int i = 0 ; i < size ; i++){
                int[] curr = queue.poll();
                for(int[] d : drs){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if(r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1){
                        grid[r][c] = 2;
                        freshOrange--;
                        queue.add(new int[] {r,c});
                        isRottin = true;
                    }
                }
            }

            if(isRottin) mins++;
        }

        return (freshOrange == 0) ? mins : -1;
    }
}