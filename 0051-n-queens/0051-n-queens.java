class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> part = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];

        backTrack(0 , n , part , res , visited , new HashSet<>() , new HashSet<>());
        return res;
    }
    private void backTrack(int row , int n , List<String> part , List<List<String>> res , boolean[] visited , Set<Integer> diag1 , Set<Integer> diag2){
        if(part.size() == n){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int col = 0 ; col < n ; col++){
            int main = row + col;
            int anti = row - col;

            if(!visited[col] && !diag1.contains(main) && !diag2.contains(anti)){
                visited[col] = true;
                diag1.add(main);
                diag2.add(anti);

                StringBuilder result = new StringBuilder();
                for(int k = 0 ; k<n ; k++) result.append(".");
                result.setCharAt(col , 'Q');

                part.add(result.toString());
                backTrack(row + 1, n , part , res , visited , diag1 , diag2);

                part.removeLast();
                visited[col] = false;
                diag1.remove(main);
                diag2.remove(anti);
            }
        }
    }
}