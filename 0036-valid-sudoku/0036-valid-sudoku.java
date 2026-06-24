class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char c = board[i][j];
                if(c == '.') continue;
                int num = (c - '0') - 1;
                int bIdx = (i / 3) * 3 + j / 3;

                if(row[num][i] || col[num][j] || box[num][bIdx]){
                    return false;
                }
                row[num][i] = true;
                col[num][j] = true;
                box[num][bIdx] = true;
            }
        }

        return true;
    }
}