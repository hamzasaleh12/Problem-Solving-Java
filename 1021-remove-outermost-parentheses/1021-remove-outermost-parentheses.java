class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();

        int left = 0;
        int balance = 0;

        boolean[] deleted = new boolean[n];
        for(int right = 0 ; right < n ; right++){
            if(s.charAt(right) == '(') balance++;
            else balance--;

            if(balance == 0) {
                deleted[left] = true;
                deleted[right] = true;

                left = right + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
            if(!deleted[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}