class WordDictionary {
    class TreeNode{
        private TreeNode[] children;
        private boolean isEnd;

        public TreeNode(){
            children = new TreeNode[26];
            isEnd = false;
        }
    }

    private TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }
    
    public void addWord(String word) {
        TreeNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char currentChar = word.charAt(i);
            int idx = currentChar - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new TreeNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
      return dfs(0 , root , word);
    }
    private boolean dfs(int i , TreeNode curr, String word){
        if(i >= word.length()) return curr.isEnd; // base case -> happy

        char currentChar = word.charAt(i);
        if(currentChar == '.'){
            for(int j = 0 ; j < 26 ; j++){
                if (curr.children[j] != null) {
                    if(dfs(i + 1 , curr.children[j] , word)) return true;
                }
            }
        } else{
            int idx = currentChar - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            return dfs(i + 1 , curr.children[idx] , word);
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */