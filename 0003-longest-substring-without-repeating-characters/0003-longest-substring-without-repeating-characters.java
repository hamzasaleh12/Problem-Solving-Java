class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int[] lastIndex = new int[128];
        int maxLength = 0;

        int left = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char curr = s.charAt(right);

            if(lastIndex[curr] != 0){
                left = Math.max(left , lastIndex[curr]);
            }

            lastIndex[curr] = right + 1;

            maxLength = Math.max(maxLength , right - left + 1);
        }
        return maxLength;
    }
}
