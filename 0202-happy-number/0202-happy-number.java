class Solution {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = helper(n);
        }
        
        return n == 1;
    }
    
    private int helper(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }
}