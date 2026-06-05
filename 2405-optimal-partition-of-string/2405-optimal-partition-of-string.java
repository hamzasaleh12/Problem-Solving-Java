class Solution {
    public int partitionString(String s) {
        if(s == null || s.length() == 0) return 0;

        boolean[] visited = new boolean[26];
        int count = 1;
        for(int i = 0 ; i < s.length() ; i++){
            int idx = s.charAt(i) - 'a';
            if(visited[idx]){
                count++;
                Arrays.fill(visited , false);
            }
            visited[idx] = true;
        }

        return count;
    }
}