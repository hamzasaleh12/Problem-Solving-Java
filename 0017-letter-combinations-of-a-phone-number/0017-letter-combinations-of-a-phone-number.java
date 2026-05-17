class Solution {
    private static final String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits , 0 , res , new StringBuilder());
        return res;
    }
    private void dfs(String digits , int count , List<String> res , StringBuilder sb){
        if(sb.length() == digits.length()){ // base case
            res.add(sb.toString());
            return;
        }

        String letters = mapping[digits.charAt(count) - '0']; // "abc"
        for(char c : letters.toCharArray()){
            sb.append(c); // a
            dfs(digits , count + 1 , res , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}