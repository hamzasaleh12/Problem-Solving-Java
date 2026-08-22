class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long prod = 1;

        int num = n;
        while(num != 0){ // 99 , 9
            int digit = num % 10; // 9 , 9
            sum += digit; // 9 , 18
            prod *= digit;  // 9 , 81

            num /= 10; // 9 , 0
        }

        return n % (sum + prod) == 0;
    }
}