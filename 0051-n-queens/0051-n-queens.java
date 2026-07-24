class Solution {
    List<String> curr = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        
        Set<Integer> dia1 = new HashSet<>();
        Set<Integer> dia2 = new HashSet<>();

        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }

        dfs(board , 0 , row , col , dia1 , dia2 , n);
        return res;
    }
    private void dfs(char[][] board , int r , boolean[] row , boolean[] col , Set<Integer> dia1 , Set<Integer> dia2 , int n){
        if(r >= n){ // success
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int c = 0 ; c < n ; c++){ // column number
            if(row[r] || col[c] || dia1.contains(r - c) || dia2.contains(r + c)) continue;
            row[r] = true; col[c] = true; dia1.add(r - c); dia2.add(r + c);
            
            board[r][c] = 'Q';
            curr.add(new String(board[r])); // [.Q..]
            dfs(board , r + 1 , row , col , dia1 , dia2 , n);

            board[r][c] = '.';
            curr.removeLast();
            row[r] = false; col[c] = false; dia1.remove(r - c); dia2.remove(r + c);
        }
    }
}