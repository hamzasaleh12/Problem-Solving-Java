class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int[] tarArr = new int[128];
        int tarUniqueElements = 0;
        for(int i = 0 ; i < t.length() ; i++){
            if(tarArr[t.charAt(i)] == 0) tarUniqueElements++;
            tarArr[t.charAt(i)]++; // b
        }

        int[] givArr = new int[128];
        int givUniqueElements = 0;
        int l = 0 , r = 0;
        int left = 0;
        int minLength = s.length() + 1;
        for(int right = 0 ; right < s.length() ; right++){
            char currChar = s.charAt(right);

            givArr[currChar]++; // a
            if(givArr[currChar] == tarArr[currChar]){ // a == a ? 
                givUniqueElements++; // 123
            }
            //System.out.println(givUniqueElements);

            while(givUniqueElements == tarUniqueElements){
                char leftCurr = s.charAt(left);

                if((right - left + 1) < minLength){
                    minLength = right - left + 1;
                    l = left;
                    r = right + 1;
                }

                if(givArr[leftCurr] == tarArr[leftCurr]){
                    givUniqueElements--;
                }

                givArr[s.charAt(left++)]--;
            }
        }
        return s.substring(l , r);
    }
}