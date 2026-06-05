class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return null;

        List<Integer> res = new ArrayList<>();

        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        
        int maxReach = 0;
        int j = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            maxReach = Math.max(maxReach , arr[currentChar - 'a']); // Update
            if(i == maxReach){
                res.add(i - j + 1);
                j = i + 1;
            }
        }

        return res;
    }
}