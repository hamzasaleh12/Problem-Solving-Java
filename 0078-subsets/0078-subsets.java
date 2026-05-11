class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        dfs(0 , nums , subset);
        return res;
    }
    private void dfs(int i , int[] nums , List<Integer> subset){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1 , nums , subset);

        subset.removeLast();
        dfs(i + 1 , nums , subset);
    }
}