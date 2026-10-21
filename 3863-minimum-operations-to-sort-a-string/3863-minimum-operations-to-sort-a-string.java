class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;
        if (n <= 2) return -1;

        char minChar = 'z';
        char maxChar = 'a';
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }

        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }

        if (s.charAt(0) == maxChar && s.charAt(n - 1) == minChar) {
            if (freq[maxChar - 'a'] == 1 && freq[minChar - 'a'] == 1) {
                return 3;
            }
        }

        return 2;
    }
}