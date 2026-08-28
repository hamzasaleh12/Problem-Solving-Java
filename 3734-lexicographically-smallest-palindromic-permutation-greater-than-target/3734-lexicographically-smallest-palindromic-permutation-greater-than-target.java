class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        if (n == 1) return s.compareTo(target) > 0 ? s : "";
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) (i + 'a');
            }
        }
        if (oddCount > 1) return "";

        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int m = n / 2;
        int maxMatch = 0;

        while (maxMatch < m && halfCount[target.charAt(maxMatch) - 'a'] > 0) {
            halfCount[target.charAt(maxMatch) - 'a']--;
            maxMatch++;
        }

        boolean needStrictlyGreater = false;

        if (maxMatch == m) {
            StringBuilder left = new StringBuilder(target.substring(0, m));
            StringBuilder full = new StringBuilder(left);
            if (n % 2 != 0) full.append(midChar);
            full.append(left.reverse());

            if (full.toString().compareTo(target) > 0) {
                return full.toString();
            } else {
                needStrictlyGreater = true; 
            }
        }

        int startBacktrack = (maxMatch == m) ? m - 1 : maxMatch;
        
        if (maxMatch == m && needStrictlyGreater) {
            halfCount[target.charAt(m - 1) - 'a']++;
        }

        for (int i = startBacktrack; i >= 0; i--) {
            char targetChar = target.charAt(i);

            for (char c = (char) (targetChar + 1); c <= 'z'; c++) {
                if (halfCount[c - 'a'] > 0) {
                    StringBuilder leftHalf = new StringBuilder(target.substring(0, i));
                    leftHalf.append(c);
                    halfCount[c - 'a']--;

                    for (char remain = 'a'; remain <= 'z'; remain++) {
                        while (halfCount[remain - 'a'] > 0) {
                            leftHalf.append(remain);
                            halfCount[remain - 'a']--;
                        }
                    }

                    StringBuilder full = new StringBuilder(leftHalf);
                    if (n % 2 != 0) full.append(midChar);
                    full.append(leftHalf.reverse());
                    
                    return full.toString();
                }
            }

            if (i > 0) {
                halfCount[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}