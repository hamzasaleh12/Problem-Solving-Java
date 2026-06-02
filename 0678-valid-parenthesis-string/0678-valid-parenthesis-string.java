class Solution {
    public boolean checkValidString(String s) {
        // Range
        int min = 0;
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            if(curr == '('){
                min++;
                max++;
            } else if(curr == ')'){
                min--;
                max--;
            } else{
                min--;
                max++;
            }

            min = Math.max(min , 0);

            if(max < 0) return false;
        }
        
        return min == 0;
    }
}