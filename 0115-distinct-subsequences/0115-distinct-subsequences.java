class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;

        int[][] memo = new int[s.length()][t.length()];
        for(int[] row : memo) Arrays.fill(row , -1);

        return dfs(0 , 0 , s , t , memo);
    }
    private int dfs(int i , int j , String s , String t , int[][] memo){
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        return memo[i][j] = (s.charAt(i) == t.charAt(j)) ? dfs(i + 1 , j + 1, s , t , memo) + dfs(i + 1 , j , s , t , memo) :
        dfs(i + 1 , j , s , t , memo);
    }
}