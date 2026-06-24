class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();

        int[] arr = new int[26];
        for(int i = 0 ; i < n ; i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < n ; i++){
            int idx = t.charAt(i) - 'a';
            if(--arr[idx] < 0) return false;
        }

        return true;
    }
}