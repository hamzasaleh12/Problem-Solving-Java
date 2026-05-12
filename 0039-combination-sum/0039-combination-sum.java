class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0 , candidates , target , 0);
        return res;
    }
    private void dfs(int i , int[] nums , int target , int val){
        if(i >= nums.length || val >= target){
            if(val == target) res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i , nums , target , val += nums[i]);

        subset.removeLast();
        dfs(i + 1 , nums , target , val -= nums[i]);
    }
}