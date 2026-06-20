class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // State transition: number of bits in (i/2) + 1 if 'i' is odd
            res[i] = res[i >> 1] + (i & 1);
        }
        
        return res;
    }
}