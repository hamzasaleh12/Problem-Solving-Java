class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isPal(i , j , s , memo)){
                    count++;
                }
            }
        }

        return count;
    }
    private boolean isPal(int i , int j , String s , int[][] memo){
        if(i >= j) return true;
        if(memo[i][j] != 0) return memo[i][j] == 2;

        if(s.charAt(i) != s.charAt(j)){
            memo[i][j] = 1;
            return false;
        }
        boolean isPal = isPal(i + 1 , j - 1 , s , memo);
        memo[i][j] = (isPal) ? 2 : 1;

        return isPal;
    }
}