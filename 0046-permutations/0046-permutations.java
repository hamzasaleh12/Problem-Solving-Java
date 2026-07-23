class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums , new boolean[nums.length] , new ArrayList<>() , res);
        return res;
    }
    private void dfs(int[] nums , boolean[] visisted , List<Integer> curr , List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(visisted[i]) continue;

            visisted[i] = true; 
            curr.add(nums[i]); // 1 , 3 , 2
            dfs(nums , visisted , curr , res); // i = 1

            visisted[i] = false;
            curr.removeLast(); // [1]
        }
    }
}