class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int count = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            count++;

            for(int k = 0 ; k < levelSize ; k++){
                StringBuilder newWord = new StringBuilder(queue.poll());

                for(int l = 0 ; l < newWord.length() ; l++){
                    char orignalChar = newWord.charAt(l);
                    for(char j = 'a' ; j <= 'z' ; j++){
                        if(j == orignalChar) continue;

                        newWord.setCharAt(l , j);
                        String tarWord = newWord.toString();

                        if(tarWord.equals(endWord)) return count + 1;

                        if(set.contains(tarWord)){
                            queue.add(tarWord);
                            set.remove(tarWord);
                        }
                    }
                    newWord.setCharAt(l , orignalChar);
                }    
            }
        }

        return 0;
    }
}