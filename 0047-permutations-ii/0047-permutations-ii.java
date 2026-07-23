class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums , new boolean[nums.length] , new ArrayList<>() , res);
        return res;
    }
    private void dfs(int[] nums , boolean[] visited , List<Integer> curr , List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; // if visited[i - 1] = true that means he placed before so that's not a dublicate
            
            visited[i] = true;
            curr.add(nums[i]); // 1 , 1 , 2
            dfs(nums , visited , curr , res);

            curr.removeLast();
            visited[i] = false;
        }
    }
}