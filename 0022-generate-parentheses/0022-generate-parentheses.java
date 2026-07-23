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
        opened++; // 4
        dfs(opened , closed , n , sb , res);

        sb.deleteCharAt(sb.length() - 1); // ((()
        opened--; // 3

        sb.append(')'); // ((())
        closed++; // 2
        dfs(opened , closed , n , sb , res);

        sb.deleteCharAt(sb.length() - 1); // ((()
        closed--; // 3
    }
}