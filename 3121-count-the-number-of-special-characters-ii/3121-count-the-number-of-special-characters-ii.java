class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int count = 0;

        for(int i = 0 ; i < word.length() ; i++){
            char currentChar = word.charAt(i);

            int index = -1; 
            boolean isLower = false;

            if(Character.isLowerCase(currentChar)){
                index = currentChar - 'a';
                isLower = true;
            } else index = currentChar - 'A';

            if(isLower){
                lowerCase[index] = i + 1;
            } else{
                if(upperCase[index] == 0) upperCase[index] = i + 1;
            }
        }

        for(int i = 0 ; i < 26 ; i++){
            if(lowerCase[i] > 0 && upperCase[i] > 0 && upperCase[i] > lowerCase[i]){
                count++;
            }
        }

        return count;
    }
}