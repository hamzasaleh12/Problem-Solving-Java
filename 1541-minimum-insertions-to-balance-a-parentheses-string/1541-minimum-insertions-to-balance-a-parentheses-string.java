class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int insertions = 0, opened = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                opened++; // 2
            } else {
                // skip the pair
                if (i < n - 1 && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++; // you want another closed one
                } // '())'

                if (opened == 0) { // '())'
                    insertions++; // you want an opened one
                } else {
                    opened--;
                }
            }
        }
        insertions += opened << 1;
        return insertions;
    }
}