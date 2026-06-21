class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String firWord = strs[0];

        for(int i = 0; i < firWord.length() ; i++){
            char curr = firWord.charAt(i);
            for(int j = 0 ; j < strs.length ; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != curr) return res.toString();
            }
            res.append(curr);
        }
        return res.toString();
    }
}