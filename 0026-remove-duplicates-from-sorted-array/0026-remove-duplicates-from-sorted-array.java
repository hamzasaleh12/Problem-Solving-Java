class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int k = 1;
        for(int right = 0 ; right < n ; right++){
            if(right > 0 && nums[right] != nums[right - 1]){
                nums[k++] = nums[right];
            }
            // if(!visited[nums[right] + 100]){
            //     nums[k++] = nums[right];
            //     visited[nums[right] + 100] = true;
            // }
        }

        return k;
    }
}