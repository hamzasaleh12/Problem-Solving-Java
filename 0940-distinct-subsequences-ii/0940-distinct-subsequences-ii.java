class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        int[] lastAdded = new int[26];
        int total = 1;

        for(int i = 0 ; i < s.length() ; i++){
            int idx = s.charAt(i) - 'a';

            int added = (total - lastAdded[idx] + MOD) % MOD;
            total = (total + added) % MOD;
            lastAdded[idx] = (lastAdded[idx] + added) % MOD;
        }
        
        return (total - 1 + MOD) % MOD;
    }
}