class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";

        int[] haveArr = new int[128];
        int have = 0;
        for(char c : t.toCharArray()){
            haveArr[c]++;
            if(haveArr[c] == 1) have++;
        }

        int[] needArr = new int[128];
        int need = 0;

        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int l = 0 , r = 0;
        for(int i = 0 ; i < s.length() ; i++){
            needArr[s.charAt(i)]++;
            if(needArr[s.charAt(i)] == haveArr[s.charAt(i)]) need++;

            while(have == need){
                if(i - left + 1 < minLength){
                    minLength = i - left + 1;
                    l=left ; r=i+1;
                }
                if(needArr[s.charAt(left)] == haveArr[s.charAt(left)]) need--;
                needArr[s.charAt(left++)]--;
            }
        }
        
        return s.substring(l,r);
    }
}
