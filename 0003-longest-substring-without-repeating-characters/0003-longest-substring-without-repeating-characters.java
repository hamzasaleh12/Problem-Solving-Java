class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();

        int i = 0;
        for(int j = 0 ; j < s.length() ; j++){
            char currChar = s.charAt(j);
            
            if(map.containsKey(currChar)){
                i = Math.max(i , map.get(currChar) + 1);
            }

            map.put(currChar , j);

            maxLength = Math.max(maxLength , j - i + 1);
        }

        return maxLength;
    }
}