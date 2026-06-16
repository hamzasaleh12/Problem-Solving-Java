class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;

        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(map.get(nums[i]) == 0) continue; // invalid start

            int start = nums[i]; // valid start
            for(int j = 0 ; j < k ; j++){
                int curr = start + j;

                if(!map.containsKey(curr) || map.get(curr) == 0) return false; // gap

                map.put(curr , map.get(curr) - 1);
            }
        }
        return true;
    }
}