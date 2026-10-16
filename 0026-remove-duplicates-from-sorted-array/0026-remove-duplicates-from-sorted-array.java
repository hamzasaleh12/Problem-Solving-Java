class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        boolean[] visited = new boolean[201];
        int k = 0;
        for(int right = 0 ; right < n ; right++){
            if(!visited[nums[right] + 100]){
                nums[k++] = nums[right];
                visited[nums[right] + 100] = true;
            }
        }

        return k;
    }
}