class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(0 , 0 , s , p , new Boolean[s.length() + 1][p.length()]);
    }
    private boolean dfs(int i , int j , String s , String p , Boolean[][] memo){
        if(j == p.length()) return i == s.length();
        if(memo[i][j] != null) return memo[i][j];

        boolean fir = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean result;
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            result = dfs(i , j + 2 , s , p , memo) || (fir && dfs(i + 1 , j , s , p , memo));
        } else{
            result = fir && dfs(i + 1 , j + 1 , s , p , memo);
        }

        return memo[i][j] = result;
    }
}