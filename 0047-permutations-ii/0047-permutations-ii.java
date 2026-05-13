class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> permute = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        dfs(nums , permute , res , used);
        return res;
    }
    private void dfs(int[] nums , List<Integer> permute , List<List<Integer>> res , boolean[] used){
        if(nums.length == permute.size()){
            res.add(new ArrayList<>(permute));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;

            used[i] = true;
            permute.add(nums[i]);
            dfs(nums , permute , res , used);

            used[i] = false;
            permute.removeLast();
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }
}