class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backTrack(0 , 0 , n , result , sb);
        return result;
    }
    private void backTrack(int open , int close , int n , List<String> res , StringBuilder sb){
        if(open > n || close > n || close > open) return;
        if(open == n && close == n){
            res.add(new String(sb.toString())); // snapshot
            return;
        }
        
        sb.append("(");
        backTrack(open + 1 , close , n , res , sb);

        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        backTrack(open , close + 1 , n , res , sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}