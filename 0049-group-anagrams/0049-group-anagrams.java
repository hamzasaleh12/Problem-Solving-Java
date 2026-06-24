class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String key = new String(wordArr);

            map.computeIfAbsent(key , k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}