class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int count = 0;

        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                lowerCase[c - 'a'] = 1;
            } else{
                upperCase[c - 'A'] = 1;
            }
        }

        for(int i = 0 ; i < 26 ; i++){
            if(lowerCase[i] == 1 && upperCase[i] == 1) count++;
        }

        return count;
    }
}