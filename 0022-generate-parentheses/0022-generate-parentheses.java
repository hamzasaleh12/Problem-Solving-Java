class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n , 0 , 0 , new StringBuilder() , res);
        return res;
    }
    private void backtrack(int n , int opened , int closed , StringBuilder sb , List<String> res){ // o(2^n)
        if(opened > n || closed > opened) return;
        if(opened == n && closed == n){
            res.add(sb.toString()); // passed by value o(n)
            return;
        }

        sb.append('(');
        backtrack(n , opened + 1 , closed , sb , res);

        sb.setCharAt(sb.length() - 1 , ')');
        backtrack(n , opened , closed + 1 , sb , res);

        sb.deleteCharAt(sb.length() - 1);
    }
}