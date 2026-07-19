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

            for(int i = 0 ; i < levelSize ; i++){
                char[] chars = queue.poll().toCharArray();

                for(int l = 0 ; l < chars.length ; l++){
                    char orignalChar = chars[l];
                    for(char c = 'a' ; c <= 'z' ; c++){
                        if(c == orignalChar) continue;

                        chars[l] = c;
                        String tarWord = new String(chars);

                        if(tarWord.equals(endWord)) return count + 1;

                        if(set.contains(tarWord)){
                            queue.add(tarWord);
                            set.remove(tarWord);
                        }
                    }
                    chars[l] = orignalChar;
                }    
            }
        }

        return 0;
    }
}