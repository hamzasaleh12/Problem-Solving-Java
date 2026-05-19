class Solution {
    public List<List<String>> partition(String s) {
        List<String> subset = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        dfs(0 , s , subset , res);
        return res;
    }
    private void dfs(int start , String s , List<String> subset , List<List<String>> res){
        if(start >= s.length()){
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i = start ; i < s.length() ; i++){
            if(isPalindrome(start , i , s)){
                subset.add(s.substring(start , i + 1));
                dfs(i + 1 , s , subset , res);
                subset.removeLast();
            }
        }
    }
    private boolean isPalindrome(int start , int end , String s){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}