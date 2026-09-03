class Solution {
    public boolean uniformArray(int[] nums1) {
        int numOfEvenNums = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums1){
            if((num & 1) == 0) numOfEvenNums++;
            min = Math.min(min , num);
        }

        return (numOfEvenNums == nums1.length) || (min & 1) == 1;
    }
}