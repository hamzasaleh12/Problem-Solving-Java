class Trie {
    class Data{
        Data[] children;
        boolean isEnd;

        public Data(){
            children = new Data[26];
            isEnd = false;
        }
    }
    
    Data root;
    public Trie() {
        root = new Data();
    }
    
    public void insert(String word) {
        Data node = root;

        for(int i = 0 ; i < word.length() ; i++){
            int idx = word.charAt(i) - 'a';

            if(node.children[idx] == null){
                node.children[idx] = new Data();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Data temp = root;

        for(int i = 0 ; i < word.length() ; i++){
            int idx = word.charAt(i) - 'a';

            if(temp.children[idx] == null) return false;

            temp = temp.children[idx];
        }

        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Data temp = root;

        for(int i = 0 ; i < prefix.length() ; i++){
            int idx = prefix.charAt(i) - 'a';

            if(temp.children[idx] == null) return false;
            temp = temp.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */