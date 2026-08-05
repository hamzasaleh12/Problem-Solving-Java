class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(); // space = o(n) , time = 
        for(String str : strs){ // o(n)
            char[] arr = str.toCharArray();
            Arrays.sort(arr); // o(k log(k))
            String key = new String(arr); // aet

            map.computeIfAbsent(key , k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}