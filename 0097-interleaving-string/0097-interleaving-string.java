class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        return dfs(0 , 0 , s1 , s2 , s3 , new Boolean[s1.length() + 1][s2.length() + 1]);
    }
    private boolean dfs(int i , int j , String s1 , String s2 , String s3 , Boolean[][] memo){ // 0,0,0 2,0,2 2,1,3 2,2,3
        if(i + j >= s3.length()) return true;
        if(memo[i][j] != null) return memo[i][j];

        return memo[i][j] = 
        (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1 , j , s1 , s2 , s3 , memo)) ||
        (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(i , j + 1 , s1 , s2 , s3 , memo));
    }
}