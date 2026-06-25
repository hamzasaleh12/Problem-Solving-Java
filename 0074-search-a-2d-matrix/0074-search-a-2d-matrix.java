class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length , cols = matrix[0].length; // 4

        int low = 0;
        int high = (rows * cols) - 1; // 11

        while(low <= high){
            int mid = (low + high) >>> 1; // 5 , 2 , 0

            int i = mid / cols; // 1 , 0 , 0
            int j = mid - (i * cols); // 5 - 4 = 1 , 2 , 0

            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) high = mid - 1; // 4 , 1
            else low = mid + 1; // 
        }

        return false;
    }
}