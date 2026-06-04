class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , i);
        }
        // System.out.println(map);
        int maxReach = 0;
        int j = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            maxReach = Math.max(maxReach , map.get(currentChar)); // 8
            if(i == maxReach){
                res.add(i - j + 1);
                j = i + 1;
            }
        }

        return res;
    }
}