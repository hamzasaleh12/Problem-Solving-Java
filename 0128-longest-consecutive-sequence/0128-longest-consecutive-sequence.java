class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longestConsecutive = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int count = 1;
                while(set.contains(num + count)){ // f
                    count++;
                }
                longestConsecutive = Math.max(longestConsecutive , count); // 1 , 4
            }
        }
        return longestConsecutive;
    }
}
