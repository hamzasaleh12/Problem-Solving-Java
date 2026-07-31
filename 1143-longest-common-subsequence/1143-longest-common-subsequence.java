class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int[] r : memo) Arrays.fill(r , -1);

        return dfs(0 , 0 , text1 , text2 , memo);
    }
    private int dfs(int i , int j , String t1 ,String t2 , int[][] memo){
        if(i >= t1.length() || j >= t2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        return memo[i][j] = (t1.charAt(i) == t2.charAt(j)) ? 1 + dfs(i + 1 , j + 1 , t1 , t2 , memo) : 
        Math.max(dfs(i + 1 , j , t1 , t2, memo) , dfs(i , j + 1 , t1 , t2 , memo));
    }
}