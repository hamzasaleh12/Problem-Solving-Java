class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Map<String,List<String>> map = new HashMap<>();
        wordSet.add(beginWord);
        int l = beginWord.length();

        for(String word : wordSet){
            for(int i = 0 ; i < l ; i++){
                StringBuilder newWord = new StringBuilder(word);
                newWord.setCharAt(i , '*');
                map.computeIfAbsent(newWord.toString() , k -> new ArrayList<>()).add(word);
            }
        }

        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        queue.add(beginWord);
        set.add(beginWord);

        int count = 1;
        boolean isFound = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int k = 0 ; k < levelSize ; k++){
                String word = queue.poll();

                if (word.equals(endWord)) return count;

                for(int i = 0 ; i < l ; i++){
                    StringBuilder newWord = new StringBuilder(word);
                    newWord.setCharAt(i , '*'); // *it , h*t , *it

                    List<String> strs = map.getOrDefault(newWord.toString() , new ArrayList<>()); // [hit] , [hit , hot] , [hit]
                    for(String str : strs){
                        if(!set.contains(str)){ // f - f,t - f
                            set.add(str);
                            queue.add(str);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}