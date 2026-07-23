class Solution {
    private final static int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(0 , i , j , board , word)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i , int r , int c , char[][] board , String word){
        if(i == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#' || word.charAt(i) != board[r][c])
        return false;


        char temp = board[r][c];
        board[r][c] = '#';
        for(int[] d : drs){
            if(dfs(i + 1 , r + d[0] , c + d[1] , board , word)) return true;
        }
        board[r][c] = temp;
        return false;
    }
}