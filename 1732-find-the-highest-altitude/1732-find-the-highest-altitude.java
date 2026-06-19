class Solution {
    public int largestAltitude(int[] gain) {
        int prefix = 0;
        int max = 0;
        for(int g : gain){
            prefix += g;
            max = Math.max(max , prefix);
        }
        return max;
    }
}