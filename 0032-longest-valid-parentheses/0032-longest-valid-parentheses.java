class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] isInValid = new boolean[n];

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else{
                if(stack.isEmpty()) isInValid[i] = true;
                else stack.pop();
            }
        }
        while(!stack.isEmpty()) isInValid[stack.pop()] = true;

        int curr = 0 , max = 0;
        for(boolean inValid : isInValid){
            if(inValid){
                curr = 0;
                continue;
            }

            curr++;
            max = Math.max(max , curr);
        }

        return max;
    }
}