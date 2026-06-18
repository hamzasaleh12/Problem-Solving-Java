class Solution {
    public double myPow(double x, int n) {
        long newN = n;
        if(newN < 0) {
            x = 1 / x;
            newN *= -1;
        }
        return pow(x , newN);
    }
    private double pow(double x, long newN){
        if(newN == 0) return 1;
        if(newN == 1) return x;

        return (newN % 2 == 0) ? pow(x * x , newN / 2) : x * pow(x , newN - 1); // 2 * pow(2,2)
    }
}