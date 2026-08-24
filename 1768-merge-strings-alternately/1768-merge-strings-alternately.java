class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0 , j = 0;
        boolean isFirst = true;
        while(i < word1.length() && j < word2.length()){
            char c1 = word1.charAt(i); // a , b
            char c2 = word2.charAt(j); // p

            if(isFirst){
                sb.append(c1); // a
                i++; // 1
                isFirst = false;
            } else{
                sb.append(c2);
                j++;
                isFirst = true;
            }
        }
        while(i < word1.length()) sb.append(word1.charAt(i++));
        while(j < word2.length()) sb.append(word2.charAt(j++));

        return sb.toString();
    }
}