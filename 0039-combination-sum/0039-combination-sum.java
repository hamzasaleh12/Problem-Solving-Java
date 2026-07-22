class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0 , 0 , candidates , target , new ArrayList<>() , res);
        return res;
    }
    private void dfs(int i , int sum , int[] nums , int target , List<Integer> curr , List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= nums.length || sum > target || sum + nums[i] > target) return;

        curr.add(nums[i]);
        dfs(i , sum + nums[i] , nums , target , curr , res);
        
        curr.removeLast();
        dfs(i + 1 , sum , nums , target , curr , res);
    }
}