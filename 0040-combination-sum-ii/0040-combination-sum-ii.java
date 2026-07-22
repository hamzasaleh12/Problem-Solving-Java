class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0 , 0 , candidates , target , new ArrayList<>() , res);
        return res;
    }
    private void dfs(int i , int val , int[] nums , int tar , List<Integer> curr , List<List<Integer>> res){
        if(val == tar){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= nums.length || val > tar || val + nums[i] > tar) return;

        curr.add(nums[i]);
        dfs(i + 1 , val + nums[i] , nums , tar , curr , res);

        while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;

        curr.removeLast();
        dfs(i + 1 , val , nums , tar , curr , res);
    }
}