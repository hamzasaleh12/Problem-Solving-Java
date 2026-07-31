class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for(int[] row : memo) Arrays.fill(row , -1);

        return dfs(word1 , 0 , word2 , 0 , memo);
    }
    private int dfs(String word1 , int i , String word2 , int j , int[][] memo){
        if(j >= word2.length()) return word1.length() - i; // delete
        if(i >= word1.length()) return word2.length() - j; // insert
        if(memo[i][j] != -1) return memo[i][j];

        
        return memo[i][j] = (word1.charAt(i) == word2.charAt(j)) ? dfs(word1 , i + 1 , word2 , j + 1 , memo) : 
        Math.min(1 + dfs(word1 , i + 1 , word2 , j + 1 , memo) , Math.min(1 + dfs(word1 , i + 1 , word2 , j , memo) , 1 + dfs(word1 , i , word2 , j + 1 , memo)));
    }
}