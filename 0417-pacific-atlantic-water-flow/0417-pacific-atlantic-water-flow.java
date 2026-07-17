class Solution {
    private static int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Fir col & Fir row --> Pacific Ocean
        boolean[][] pacific = new boolean[rows][cols];
        // Las col & Las row --> Atlantic Ocean
        boolean[][] atlantic = new boolean[rows][cols];

        // Fir & Last row
        for(int i = 0 ; i < cols ; i++){
            helper(heights , pacific , 0 , i , heights[0][i]);
            helper(heights , atlantic , rows - 1 , i , heights[rows - 1][i]);
        }

        // Fir & Last col
        for(int i = 0 ; i < rows ; i++){
            helper(heights , pacific , i , 0 , heights[i][0]);
            helper(heights , atlantic , i , cols - 1 , heights[i][cols - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(pacific[i][j] && atlantic[i][j]) res.add(List.of(i , j));
            }
        }

        return res;
    }

    private void helper(int[][] heights , boolean[][] ochean , int r , int c , int min){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || ochean[r][c] || heights[r][c] < min) return;
        ochean[r][c] = true;

        for(int[] d : drs){
            helper(heights , ochean , r + d[0] , c + d[1] , heights[r][c]);
        }
    }
}