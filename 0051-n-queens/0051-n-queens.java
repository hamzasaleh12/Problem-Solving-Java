class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> part = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] diag1 = new boolean[n * 2];
        boolean[] diag2 = new boolean[n * 2];

        backTrack(0 , n , part , res , visited , diag1 , diag2);
        return res;
    }
    private void backTrack(int row , int n , List<String> part , List<List<String>> res , boolean[] visited , boolean[] diag1 , boolean[] diag2){
        if(part.size() == n){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int col = 0 ; col < n ; col++){
            int main = row + col;
            int anti = row - col + (n - 1);

            if(!visited[col] && !diag1[main] && !diag2[anti]){
                visited[col] = true;
                diag1[main] = true;
                diag2[anti] = true;

                char[] charArr = new char[n];
                Arrays.fill(charArr , '.');
                charArr[col] = 'Q';
                part.add(new String(charArr));

                backTrack(row + 1, n , part , res , visited , diag1 , diag2);

                part.removeLast();
                visited[col] = false;
                diag1[main] = false;
                diag2[anti] = false;
            }
        }
    }
}