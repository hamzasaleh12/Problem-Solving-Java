class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> curr = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        boolean[] visited = new boolean[n];
        boolean[] diag1 = new boolean[n * 2];
        boolean[] diag2 = new boolean[n * 2];

        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        dfs(0 , n , curr , res , visited , diag1 , diag2 , board);
        return res;
    }
    private void dfs(int r , int n , List<String> curr , List<List<String>> res , boolean[] col , boolean[] dia1 , boolean[] dia2 ,
    char[][] board){

        if(r == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int c = 0 ; c < n ; c++){
            int main = r + c;
            int anti = r - c + (n - 1);

            if(!col[c] && !dia1[main] && !dia2[anti]){
                col[c] = true; dia1[main] = true; dia2[anti] = true;

                board[r][c] = 'Q';
                curr.add(new String(board[r]));
                dfs(r + 1, n , curr , res , col , dia1 , dia2 , board);

                board[r][c] = '.';
                curr.removeLast();
                col[c] = false; dia1[main] = false; dia2[anti] = false;
            }
        }
    }
}