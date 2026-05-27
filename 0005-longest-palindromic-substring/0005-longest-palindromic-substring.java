class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s.charAt(0) + "";
        int l = 0;
        int r = 0;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length() ; i++){
            char currChar = s.charAt(i);

            int[] oddVal = helper(i , i , s);
            int[] evenVal = helper(i , i + 1 , s);

            if(oddVal[2] > evenVal[2]){
                if(oddVal[2] > max){
                    max = oddVal[2];
                    l = oddVal[0];
                    r = oddVal[1];
                }
            } else{
                if(evenVal[2] > max){
                    max = evenVal[2];
                    l = evenVal[0];
                    r = evenVal[1];
                } 
            }
        }
        return s.substring(l , r + 1);
    }
    private int[] helper(int left , int right , String word){
        while(left >= 0 && right < word.length()){
            if(word.charAt(left) != word.charAt(right)) break;
            left--;
            right++;
        }
        return new int[]{left + 1 , right - 1 , right - left + 1};
    }
}