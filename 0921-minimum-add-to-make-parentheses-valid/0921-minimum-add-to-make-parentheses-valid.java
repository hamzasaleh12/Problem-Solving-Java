class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int min = 0;

        int curr = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') curr++; // inc
            else{
                if(curr <= 0) min++; // ())
                else curr--; // dec
            }
        }

        return min + curr;
    }
}