class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0 , 0 , n , new StringBuilder() , res);
        return res;
    }
    private void dfs(int opened , int closed , int n , StringBuilder sb , List<String> res){
        if(closed > opened || opened > n) return;
        if(opened == n && closed == n){
            res.add(sb.toString());
            return;
        }

        sb.append('('); // ((()(
        dfs(opened + 1 , closed , n , sb , res);
        sb.deleteCharAt(sb.length() - 1); // ((()

        sb.append(')'); // ((())
        dfs(opened , closed + 1 , n , sb , res);
        sb.deleteCharAt(sb.length() - 1); // ((()
    }
}