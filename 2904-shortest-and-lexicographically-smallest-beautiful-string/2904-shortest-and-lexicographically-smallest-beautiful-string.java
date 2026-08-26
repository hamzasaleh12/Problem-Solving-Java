class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0 , min = Integer.MAX_VALUE;
        String res = "";

        for(int right = 0 ; right < s.length() ; right++){
            if(s.charAt(right) == '1') ones++; // 1

            while(ones == k){
                int len = right - left + 1; // 6
                String curr = s.substring(left , right + 1);

                if(len < min){ // t
                    min = len; // 6
                    res = curr; // "100011"
                } else if(len == min){
                    if(res.equals("") || res.compareTo(curr) > 0){
                        res = curr;
                    }
                }

                if(s.charAt(left) == '1') ones--;
                left++;
            }
        }
        return res;
    }
}