class Solution {
    public String lexGreaterPermutation(String s, String tar) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int len = s.length();
        int maxMatch = 0;
        while (maxMatch < len && count[tar.charAt(maxMatch) - 'a'] > 0) {
            count[tar.charAt(maxMatch) - 'a']--;
            maxMatch++;
        }

        if (maxMatch == len) {
            maxMatch--;
            count[tar.charAt(maxMatch) - 'a']++;
        }

        for (int i = maxMatch; i >= 0; i--) {
            char targetChar = tar.charAt(i);

            for (char c = (char) (targetChar + 1); c <= 'z'; c++) {
                if (count[c - 'a'] > 0) {
                    StringBuilder res = new StringBuilder();
                    
                    res.append(tar.substring(0, i));
                    
                    res.append(c);
                    count[c - 'a']--;

                    for (char remain = 'a'; remain <= 'z'; remain++) {
                        while (count[remain - 'a'] > 0) {
                            res.append(remain);
                            count[remain - 'a']--;
                        }
                    }
                    
                    return res.toString();
                }
            }

            if (i > 0) {
                count[tar.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}