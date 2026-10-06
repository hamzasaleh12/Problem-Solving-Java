class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int min = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                if(stack.isEmpty()) min++; // ())
                else stack.pop();
            }
        }

        while(!stack.isEmpty()){ // (()
            stack.pop();
            min++;
        }

        return min;
    }
}