class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        
        int[] pArr = new int[26];
        for(char c : p.toCharArray()){
            pArr[c - 'a']++;
        }

        int[] sArr = new int[26];
        int left = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char curr = s.charAt(right);
            sArr[curr - 'a']++;

            if(right >= p.length() - 1){
                if(Arrays.equals(pArr , sArr)) result.add(left);
        
                sArr[s.charAt(left++) - 'a']--;
            }
        }
        return result;
    }
}
