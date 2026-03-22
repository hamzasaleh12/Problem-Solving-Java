class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int[] lastIndex = new int[128];
        int maxLength = 0;
        Arrays.fill(lastIndex , -1);

        int left = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char curr = s.charAt(right); // p , w , w
            if(lastIndex[curr] != -1){ // f , f , t
                left = Math.max(left , lastIndex[curr] + 1); // left=2
            }
            lastIndex[curr] = right; // [p]=0 , [w]=1 , [w]=2

            maxLength = Math.max(maxLength , right - left + 1); // max=2
        }
        return maxLength;
    }
}
