class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        
        int prev = 1 , i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(char c : seq.toCharArray()){
            if(c == '('){
                int curr = (prev == 1) ? 0 : 1;

                ans[i++] = curr;
                stack.push(curr);
            } else{
                ans[i++] = stack.pop();
            }

            if(!stack.isEmpty()) prev = stack.peek();
        }

        return ans;
    }
}