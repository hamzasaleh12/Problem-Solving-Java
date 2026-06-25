class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for(int i = 0 ; i < s1.length() ; i++){
            s1Arr[s1.charAt(i) - 'a']++; // ab
            s2Arr[s2.charAt(i) - 'a']++; // ei
        }

        if(Arrays.equals(s1Arr , s2Arr)) return true; // f

        int left = 0;
        for(int right = s1.length() ; right < s2.length() ; right++){
            s2Arr[s2.charAt(right) - 'a']++;
            s2Arr[s2.charAt(left++) - 'a']--;

            if(Arrays.equals(s1Arr , s2Arr)) return true;
        }

        return false;
    }
}