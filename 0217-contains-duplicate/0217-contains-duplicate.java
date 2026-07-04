class Solution {
    public boolean containsDuplicate(int[] nums) {
         // o(n^2) -> o(n) -> o(n log(n))
         // o(1) -> o(n) -> o(1)
        Set<Integer> set = new HashSet<>(); // add o(1) , remove o(1) , contains o(1)
        for(int num : nums){
            if(!set.add(num)) return true;
        }
        return false;
    }
}