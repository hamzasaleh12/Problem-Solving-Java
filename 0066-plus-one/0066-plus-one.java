class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; // 1
        if(digits[n - 1] != 9){
            digits[n - 1]++;
            return digits;
        }
        
        for(int j = n - 1 ; j >= 0 ; j--){
            if(digits[j] == 9) digits[j] = 0;
            else{
                digits[j]++;
                break;
            }
        }

        if(digits[0] == 0){
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }
}