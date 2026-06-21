class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int newA = a;
            a = a ^ b;
            b = (newA & b) << 1;
        }

        return a;
    }
}