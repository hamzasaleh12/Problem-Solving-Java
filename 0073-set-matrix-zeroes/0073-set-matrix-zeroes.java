class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isFirCol = false;
        for(int row = 0 ; row < rows ; row++){
            if(matrix[row][0] == 0) isFirCol = true;

            for(int col = 1 ; col < cols ; col++){
                if(matrix[row][col] == 0){
                   matrix[row][0] = 0;
                   matrix[0][col] = 0;
                }
            }
        }

        for(int i = 1 ; i < rows ; i++){
            for(int j = 1 ; j < cols ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){ // fir row
            for(int i = 0 ; i < cols ; i++){
                matrix[0][i] = 0;
            }
        }

        if(isFirCol){
            for(int i = 0 ; i < rows ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}