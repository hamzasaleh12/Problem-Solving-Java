class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo , -1);

        return dfs(0 , s , memo); // "11" , "1"
    }
    private int dfs(int i ,String s , int[] memo){ // 0
        if(i == s.length()) return 1; // == 3
        if(i > s.length() || s.charAt(i) == '0') return 0; // > 3

        if(memo[i] != -1) return memo[i];

        int ways = dfs(i + 1 , s , memo); // 1

        if(i + 1 < s.length()){
            int firNum = s.charAt(i) - '0';
            int secNum = s.charAt(i + 1) - '0';
            if(firNum == 1 || (firNum == 2 && secNum <= 6)){
                ways += dfs(i + 2 , s , memo);
            }
        }

        return memo[i] = ways;
    }
}