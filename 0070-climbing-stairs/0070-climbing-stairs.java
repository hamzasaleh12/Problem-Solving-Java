class Solution {
    public int climbStairs(int n) {
        int b1 = 1 ; int b2 = 1;

        for(int i = n - 2 ; i >= 0 ; i--){
            int temp = b1; // 3
            b1 = b1 + b2; // 5
            b2 = temp; // 3
        }

        return b1;
    }
}