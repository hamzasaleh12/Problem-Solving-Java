class Solution {
    HashSet<Integer> set = new HashSet<>();
    List<Integer> permute = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }
    private void dfs(int[] nums){
        if(nums.length == permute.size()){
            res.add(new ArrayList<>(permute));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!set.add(nums[i])) continue;

            permute.add(nums[i]);
            dfs(nums);
            set.remove(permute.removeLast());
        }
    }
}