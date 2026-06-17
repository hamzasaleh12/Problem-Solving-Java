class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; // 1

        for(int j = n - 1 ; j >= 0 ; j--){
            if(digits[j] == 9) digits[j] = 0;
            else{
                digits[j]++;
                return digits;
            }
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}