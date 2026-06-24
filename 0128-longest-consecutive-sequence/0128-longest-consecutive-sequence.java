class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        int maxLength = 0;
        for(int n : set){
            if(!set.contains(n - 1)){ // start of the chain
                int count = 1;
                int num = n;
                while(set.contains(++num)){
                    count++;
                }
                maxLength = Math.max(maxLength , count);
            }
        }

        return maxLength;
    }
}