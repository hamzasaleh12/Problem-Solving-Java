class Solution {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null) return false;

        int l = board.length; int w = board[0].length;
        char start = word.charAt(0);

        for(int i = 0 ; i < l ; i++){
            for(int j = 0 ; j < w ; j++){
                if(start == board[i][j]){
                    if(dfs(board , i , j, word , 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private boolean dfs(char[][] board, int r , int c , String word , int idx){
        if(idx == word.length()){
            return true;
        }
        if(r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] == '#' || board[r][c] != word.charAt(idx)) return false;

        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, r + 1, c, word, idx + 1) ||
                        dfs(board, r - 1, c, word, idx + 1) ||
                        dfs(board, r, c + 1, word, idx + 1) ||
                        dfs(board, r, c - 1, word, idx + 1);
        board[r][c] = temp;

        return found;
    }    
}