class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dfs(0 , 1 , s , set , new Boolean[s.length()][s.length() + 1]);
    }
    private boolean dfs(int i , int j , String s , Set<String> set , Boolean[][] memo){ // 0 , 1
        if(i == s.length()) return true; // 2
        if(j > s.length()) return false; // 3
        if(memo[i][j] != null) return memo[i][j];

        return memo[i][j] = (set.contains(s.substring(i , j))) ? dfs(i , j + 1 , s , set , memo) || dfs(j , j + 1 , s , set , memo) : dfs(i , j + 1 , s , set , memo);
    }
}