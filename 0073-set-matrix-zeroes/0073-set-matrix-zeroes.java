class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<int[]> list = new ArrayList<>();
        for(int row = 0 ; row < rows ; row++){
            for(int col = 0 ; col < cols ; col++){
                if(matrix[row][col] == 0){ // 0 , 3
                    list.add(new int[]{row , col});
                }
            }
        }

        for(int i = 0 ; i < list.size() ; i++){
            int[] curr = list.get(i);
            setRows(curr[0] , cols , matrix);
            setCols(curr[1] , rows , matrix);
        }
    }
    private void setRows(int row , int cols , int[][] matrix){
        for(int i = 0 ; i < cols ; i++){
            matrix[row][i] = 0;
        }
    }
    private void setCols(int col , int rows , int[][] matrix){
        for(int i = 0 ; i < rows ; i++){
            matrix[i][col] = 0;
        }
    }
}