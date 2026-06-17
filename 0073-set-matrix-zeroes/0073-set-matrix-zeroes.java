class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] setRow = new boolean[rows];
        boolean[] setCol = new boolean[cols];
        for(int row = 0 ; row < rows ; row++){
            for(int col = 0 ; col < cols ; col++){
                if(matrix[row][col] == 0){ // 0 , 3
                    setRow[row] = true;
                    setCol[col] = true;
                }
            }
        }

        for(int i = 0 ; i < Math.max(rows,cols) ; i++){
            if(i < rows && setRow[i]) setRows(i , cols , matrix);
            if(i < cols && setCol[i]) setCols(i , rows , matrix);
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