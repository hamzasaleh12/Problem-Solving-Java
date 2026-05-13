class Solution {
    private static final int[][] drs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private boolean isFound = false;

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null) return false;

        int l = board.length; int w = board[0].length;
        char start = word.charAt(0); // 'A'
        boolean[][] visited = new boolean[l][w];
        for(int i = 0 ; i < l ; i++){
            for(int j = 0 ; j < w ; j++){
                if(isFound) return true;
                if(start == board[i][j]){
                    dfs(board , i , j, word , 0 , visited);
                }
            }
        }
        return isFound;
    }
    private void dfs(char[][] board, int x , int y , String word , int idx , boolean[][] visited){
        if(isFound) return;
        if(idx == word.length()){
            isFound = true;
            return;
        }
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0 || visited[x][y]) return;

        if(board[x][y] == word.charAt(idx)){
            visited[x][y] = true;
            for(int[] d : drs){
                dfs(board , x + d[0] , y + d[1] , word , idx + 1 , visited);
            }
            visited[x][y] = false;
        }
    }    
}