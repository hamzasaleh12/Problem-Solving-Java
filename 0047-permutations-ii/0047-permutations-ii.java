class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if(i > 0 && nums[i] == nums[i - 1] && !visisted[i - 1]) continue; // if visisted[i - 1] = true that means he placed before so that's not a dublicate
            
            visisted[i] = true;
            curr.add(nums[i]); // 1 , 1 , 2
            dfs(nums , visisted , curr , res);

            curr.removeLast();
            visisted[i] = false;
        }
    }
}