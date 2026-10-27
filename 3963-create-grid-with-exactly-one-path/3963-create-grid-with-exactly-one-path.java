class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        
        for(int i = 0 ; i < m ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                if(i == m - 1) sb.append('.');
                else if(j == 0) sb.append('.');
                else sb.append('#');
            }
            res[i] = sb.toString();
        }

        return res;
    }
}