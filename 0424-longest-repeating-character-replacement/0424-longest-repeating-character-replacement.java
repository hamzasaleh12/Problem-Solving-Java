class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr  = new int[26];
        int maxLength = 0;
        int maxFrequent = 0;
        int i = 0;
        for(int j = 0 ; j < s.length() ; j++){
            int frequent = ++arr[s.charAt(j) - 'A'];
            maxFrequent = Math.max(maxFrequent , frequent);
            
            if((j - i + 1) - maxFrequent > k){
                arr[s.charAt(i++) - 'A']--;
            }

            maxLength = Math.max(maxLength , j - i + 1);
        }

        return maxLength;
    }
}