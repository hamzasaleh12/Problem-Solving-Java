class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFreq = 0;
        int left = 0;

        int[] arr = new int[26];
        for(int right = 0; right < s.length() ; right++){
            char curr = s.charAt(right); // A , A , B , A , B
            arr[curr - 'A']++; // A=1 , A=2 , B=1 , A=3 , B=2
            maxFreq = Math.max(maxFreq , arr[curr - 'A']); // 3

            while((right - left + 1) - maxFreq > k){ // 2 - 1 = 1 > 1 ? f , 3-3=0 , 3-
                arr[s.charAt(left++) - 'A']--; // A,A,B
            }

            maxLength = Math.max(maxLength , right - left + 1); // 3,4
        }
        return maxLength;
    }
}