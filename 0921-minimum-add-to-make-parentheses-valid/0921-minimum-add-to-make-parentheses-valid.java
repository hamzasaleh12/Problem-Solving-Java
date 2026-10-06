class Solution {
    public int minAddToMakeValid(String s) {
        int minInserions = 0;
        int sizeOfStack = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') sizeOfStack++; // inc
            else{
                if(sizeOfStack <= 0) minInserions++; // ())
                else sizeOfStack--; // dec
            }
        }

        return minInserions + sizeOfStack;
    }
}