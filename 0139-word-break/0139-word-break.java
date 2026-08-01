class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dfs(0 , s , set , new Boolean[s.length()]);
    }
    private boolean dfs(int i , String s , Set<String> set , Boolean[] memo){ // 0 , 1
        if(i == s.length()) return true; // 2
        if(memo[i] != null) return memo[i];

        for(int j = i + 1 ; j <= s.length() ; j++){
            if(set.contains(s.substring(i , j)) && dfs(j, s, set, memo)){
                return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}