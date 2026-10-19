class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        int prevNums = 0 , tarIdxs = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < target) prevNums++;
            else if(nums[i] == target) tarIdxs++;
        }
        List<Integer> res = new ArrayList<>(tarIdxs);

        int count = 0;
        while(count < tarIdxs){
            res.add(prevNums + count); // 1 + 0,1
            count++;
        }

        return res;
    }
}