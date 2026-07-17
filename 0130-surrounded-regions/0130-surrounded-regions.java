class Solution {
    private static int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0 ; i < rows ; i++){ // fir col
            if(board[i][0] == 'O') dfs(board , i , 0);
        }
        for(int i = 0 ; i < rows ; i++){ // last col
            if(board[i][cols - 1] == 'O') dfs(board , i , cols - 1);
        }
        for(int i = 0 ; i < cols ; i++){ // fir row
            if(board[0][i] == 'O') dfs(board , 0 , i);
        }
        for(int i = 0 ; i < cols ; i++){ // last row
            if(board[rows - 1][i] == 'O') dfs(board , rows - 1 , i);
        }

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == 'T') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board , int row , int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = 'T';

        for(int[] d : drs){
            dfs(board , row + d[0] , col + d[1]);
        }
    }
}