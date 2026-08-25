class Solution {
    public int missingMultiple(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        Set<Integer> set = new HashSet<>(list);

        int num = k; 
        while(set.contains(num)){
            num += k;
        }

        return num;
    }
}