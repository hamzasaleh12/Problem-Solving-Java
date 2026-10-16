class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> list = new LinkedHashSet<>(Arrays.stream(nums).boxed().toList());

        int k = 0;
        for(Integer num : list) nums[k++] = num;

        return k;
    }
}