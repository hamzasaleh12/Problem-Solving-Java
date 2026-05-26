class Solution {
    class TreeNode{
        private TreeNode[] children;
        private boolean isEnd;

        public TreeNode(){
            children = new TreeNode[26];
            isEnd = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = new TreeNode();
        List<String> res = new ArrayList<>();

        for(String word : words){
            addWord(word , root);
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0; j < board[0].length ; j++){
                dfs(i , j , root , board , new StringBuilder() , res);
            }
        }
        return res;
    }
    private void dfs(int row , int col , TreeNode curr , char[][] board , StringBuilder word , List<String> res){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') return;

        char currChar = board[row][col];
        int idx = currChar - 'a';

        if(curr.children[idx] == null) return;
        curr = curr.children[idx];

        word.append(currChar);
        if(curr.isEnd){
            res.add(word.toString());
            curr.isEnd = false;
        }

        board[row][col] = '#';
        dfs(row + 1 , col , curr , board , word , res);
        dfs(row , col + 1 , curr , board , word , res);
        dfs(row - 1 , col , curr , board , word , res);
        dfs(row , col - 1 , curr , board , word , res);
        board[row][col] = currChar; // backtrack
        word.deleteCharAt(word.length() - 1);
    }
    private void addWord(String word , TreeNode root){
        TreeNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char currChar = word.charAt(i);
            int idx = currChar - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new TreeNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
}