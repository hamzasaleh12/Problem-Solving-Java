class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1 ; i < words.length ; i++){
            String word1 = words[i - 1] , word2 = words[i];

            if(word1.length() > word2.length() && word1.startsWith(word2)) return false;
            
            for(int j = 0 ; j < Math.min(word1.length() , word2.length()) ; j++){
                char c1 = word1.charAt(j) , c2 = word2.charAt(j);

                if(c1 != c2){
                    if(arr[c1 - 'a'] > arr[c2 - 'a']) return false;
                    else break;
                }
            }
        }
        // speed = o(n * k)
        // space = o(1) -> 26

        return true;
    }
}