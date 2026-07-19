class Solution {
    char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int count = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            count++; //3

            for(int k = 0 ; k < levelSize ; k++){
                String word = queue.poll();

                for(int l = 0 ; l < word.length() ; l++){
                    StringBuilder newWord = new StringBuilder(word); // hit -> hot
                    for(int j = 0 ; j < 26 ; j++){
                        // a - > z
                        newWord.setCharAt(l , arr[j]);
                        String tarWord = newWord.toString();

                        if(tarWord.equals(endWord)) return count + 1;

                        if(set.contains(tarWord)){
                            queue.add(tarWord); // hot -- dot,lot -- dog,log -- 
                            set.remove(tarWord); // cut the cycle
                        }
                    }
                }    
            }
        }

        return 0;
    }
}