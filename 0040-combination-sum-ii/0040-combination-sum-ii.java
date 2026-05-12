class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0 , candidates , target , 0);
        return res;
    }
    private void dfs(int i , int[] nums , int target , int val){
        if(i >= nums.length || val >= target){
            if(val == target) res.add(new ArrayList<>(subset));
            return;
        }
        if(nums[i] + val > target) return;

        subset.add(nums[i]);
        dfs(i + 1 , nums , target , val + nums[i]);

        subset.removeLast();
        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        dfs(i + 1 , nums , target , val);
    }
}