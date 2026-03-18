class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j <9 ; j++){
                if(board[i][j] != '.'){
                int val = board[i][j] - '1'; // 0 -> 8
                int bdx = (i / 3) * 3 + j / 3;
                if(row[i][val] || col[j][val] || box[bdx][val]){
                    return false;
                }
                row[i][val] = true;
                col[j][val] = true;
                box[bdx][val] = true;
                }
            }
        }
        return true;
    }
}