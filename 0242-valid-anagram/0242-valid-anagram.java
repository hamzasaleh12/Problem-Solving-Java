class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();

        int[] arrS = new int[26];
        int[] arrT = new int[26];
        for(int i = 0 ; i < n ; i++){
            arrS[s.charAt(i) - 'a']++;
            arrT[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(arrS , arrT);
    }
}