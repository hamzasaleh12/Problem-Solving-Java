class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] set = new boolean[101 * 101];
        for(int num : nums) set[num] = true;

        int num = k; 
        while(set[num]){
            num += k;
        }

        return num;
    }
}