class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; // dub -> i

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(List.of(nums[i] , nums[left] , nums[right]));
                    right--;
                    left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;  // dub -> r
                    while(left < right && nums[left] == nums[left - 1]) left++;     // dub -> l
                }
                else if(sum > 0){
                    right--;
                    while(left < right && nums[right] == nums[right + 1]) right--; // dub -> r
                } else{
                    left++;
                    while(left < right && nums[left] == nums[left - 1]) left++; // // dub -> l
                }
            }
        }

        return res;
    }
}