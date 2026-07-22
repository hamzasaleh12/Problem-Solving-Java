class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0 , nums , new ArrayList<>() , res);
        return res;
    }
    private void dfs(int i , int[] nums , List<Integer> curr , List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(curr)); // [1,2,2] , [1,2]
            return;
        }

        curr.add(nums[i]); // 1 , 2 , 2
        dfs(i + 1 , nums , curr , res); // 1 , 2

        while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;

        curr.removeLast(); // 1 , 2
        dfs(i + 1 , nums , curr , res);

    }
}