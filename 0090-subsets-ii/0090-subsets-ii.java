class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        dfs(0 , nums , subset , res);

        return res;
    }
    private void dfs(int i , int[] nums , List<Integer> subset , List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1 , nums , subset , res);

        subset.removeLast();
        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        dfs(i + 1 , nums , subset , res);
    }
}