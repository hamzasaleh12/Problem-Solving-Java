class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] visited = new boolean[128];
        int count = 0;
        int len = word.length();

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            
            if (visited[c]) continue;
            
            visited[c] = true;

            if (c >= 'a'){
                if (visited[c - 32]) count++;
            } else{
                if (visited[c + 32]) count++;
            }
        }

        return count;
    }
}