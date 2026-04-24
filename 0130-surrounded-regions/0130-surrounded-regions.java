class Solution {
    private static final int[][] drs = {{1,0} , {0,1} , {-1,0} , {0,-1}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows ; i++) if(board[i][0] == 'O') dfs(i , 0 ,board);
        for(int i = 0; i < rows ; i++) if(board[i][cols - 1] == 'O') dfs(i , cols - 1 ,board);

        for(int i = 0; i < cols ; i++) if(board[0][i] == 'O') dfs(0 , i ,board);
        for(int i = 0; i < cols ; i++) if(board[rows - 1][i] == 'O') dfs(rows - 1 , i ,board);


        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                } else{
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(int r , int c , char[][] board){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;

        board[r][c] = 'T';

        for(int i = 0 ; i < 4 ; i++){
            dfs(r + drs[i][0] , c + drs[i][1] , board);
        }
    }
}