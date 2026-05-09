class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++){
            map.put(order.charAt(i) , i);
        }

        boolean isInOrder = true;
        for(int i = 1 ; i < words.length ; i++){
            String word1 = words[i - 1] , word2 = words[i];

            if(word1.length() > word2.length() && word1.startsWith(word2)) return false;
            
            for(int j = 0 ; j < Math.min(word1.length() , word2.length()) ; j++){
                char c1 = word1.charAt(j) , c2 = word2.charAt(j);

                if(c1 != c2){
                    if(map.get(c1) > map.get(c2)) return false;
                    else break;
                }
            }
        }

        return true;
    }
}