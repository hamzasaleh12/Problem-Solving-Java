class Solution {
    public int scoreOfParentheses(String s) {
        int[] ptr = new int[]{0};
        return parse(s, ptr);
    }

    private int parse(String s, int[] ptr) {
        int score = 0;

        while (ptr[0] < s.length() && s.charAt(ptr[0]) != ')') {
            
            if (s.charAt(ptr[0] + 1) == ')') {
                score++;
                ptr[0] += 2;
            } else {
                ptr[0]++;             
                score += 2 * parse(s, ptr);
                ptr[0]++;
            }
        }

        return score;
    }
}