class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        // 1.Get the number of inValid parentheses(k) -> o(n)
        int stack = 0;
        int remOpened = 0 , remClosed = 0;
        for(char c : s.toCharArray()){
            if(c == '(') stack++; // ++
            else if(c == ')'){
                if(stack <= 0) remClosed++; // ())
                else stack--; // --
            }
        }
        remOpened = stack;

        Set<String> result = new HashSet<>();
        // 2.Try all possible ways to remove (k) paranthses(result) -> o(n * 2^k)
        dfs(0 , remOpened , remClosed , s , new StringBuilder() , result);

        return new ArrayList<>(result);
    }
    private void dfs(int i , int remOpened , int remClosed , String s, StringBuilder sb , Set<String> res){ // ()())()
        if(i == s.length() && remOpened == 0 && remClosed == 0 && isValid(sb)){
            res.add(sb.toString());
            return;
        }
        if(i >= s.length() || remOpened < 0 || remClosed < 0) return;
        
        char c = s.charAt(i);
        if(c == '(') {
            dfs(i + 1 , remOpened - 1 , remClosed , s , sb , res); // didn't take it
        } else if(c == ')'){
            dfs(i + 1 , remOpened , remClosed - 1 , s , sb , res); // didn't take it
        }

        sb.append(c);
        dfs(i + 1 , remOpened , remClosed , s , sb , res); // take it
        sb.deleteCharAt(sb.length() - 1);
    }
    private boolean isValid(StringBuilder sb){
        int stack = 0;
        for(int i = 0 ; i < sb.length() ; i++){
            char c = sb.charAt(i);

            if(c == '(') stack++; // ++
            else if(c == ')'){
                if(stack <= 0) return false; // ())
                else stack--; // --
            }
        }
        return stack == 0;
    } 
}