class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        // System.out.println(map);
        int maxReach = 0;
        int j = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            maxReach = Math.max(maxReach , arr[currentChar - 'a']); // 8
            if(i == maxReach){
                res.add(i - j + 1);
                j = i + 1;
            }
        }

        return res;
    }
}