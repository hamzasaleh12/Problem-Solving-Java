class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        // {[1,3] , [2,2] , [3,1]}

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // {[] [] [] [1] [2] [3]};
        int count = 0;
        int[] result = new int[k];
        for(int i = nums.length ; i >= 1 ; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    result[count++] = num;
                    if(count == k) return result;
                }
            }
        }
        return new int[0];
    }
}