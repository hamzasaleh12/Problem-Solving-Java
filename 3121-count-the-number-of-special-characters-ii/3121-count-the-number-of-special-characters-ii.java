class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int count = 0;

        for(int i = 0 ; i < word.length() ; i++){
            char currentChar = word.charAt(i);

            if(Character.isLowerCase(currentChar)){
                lowerCase[currentChar - 'a'] = i + 1;
            } else{
                int index = currentChar - 'A';
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