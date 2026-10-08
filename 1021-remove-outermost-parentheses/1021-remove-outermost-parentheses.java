class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();

        int left = n - 1;
        int balance = 0;

        StringBuilder sb = new StringBuilder(s);
        for(int right = n - 1 ; right >= 0 ; right--){
            if(s.charAt(right) == ')') balance++;
            else balance--;

            if(balance == 0) {
                sb.deleteCharAt(left);
                sb.deleteCharAt(right);

                left = right - 1;
            }
        }

        return sb.toString();
    }
}