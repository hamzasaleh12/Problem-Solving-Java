class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int l = 0, r = 0;

        while(r < nums.length - 1){
            int farthest = 0;
            for(int i = 0 ; i < r + 1 ; i++){
                //if(i >= nums.length) return count + 1;
                farthest = Math.max(farthest , nums[i] + i);
            }
            l = r + 1;
            r = farthest;
            count++;
        }
        return count;
    }
}