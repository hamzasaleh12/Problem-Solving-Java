class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; // 1
        if(digits[n - 1] != 9){
            digits[n - 1]++;
            return digits;
        }
        
        int j = n - 1;
        while(j >= 0 && digits[j] == 9){
            digits[j--] = 0;
        }

        if(digits[0] == 0){
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        digits[j]++;
        return digits;
    }
}