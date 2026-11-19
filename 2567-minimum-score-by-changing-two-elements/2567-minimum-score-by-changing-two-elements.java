class Solution {
    public int minimizeSum(int[] nums) {
        Integer[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0};
        int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0};

        for (int num : nums) {
            max[3] = num;
            Arrays.sort(max, (a,b) -> Integer.compare(b,a));

            min[3] = num;
            Arrays.sort(min);
        }

        int dropTwoSmallest = max[0] - min[2];
        int dropTwoLargest  = max[2] - min[0];
        int dropOneEach     = max[1] - min[1];

        return Math.min(dropTwoSmallest, Math.min(dropTwoLargest, dropOneEach));
    }
}