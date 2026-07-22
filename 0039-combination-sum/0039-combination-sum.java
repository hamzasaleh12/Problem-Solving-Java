class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, int sum, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }

            curr.add(nums[i]);
            dfs(i, sum + nums[i], nums, target, curr, res); 

            curr.removeLast();
        }
    }
}