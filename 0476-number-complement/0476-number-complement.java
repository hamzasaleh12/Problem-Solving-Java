class Solution {
    public int findComplement(int num) {
        int bitCount = (int) (Math.log(num) / Math.log(2)) + 1;
        int mask = (1 << bitCount) - 1;
        return num ^ mask;
    }
}