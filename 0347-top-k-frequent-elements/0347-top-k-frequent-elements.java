class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[n + 1];
        for(int num : map.keySet()){
            int f = map.get(num);
            if(buckets[f] == null){
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }

        int[] res = new int[k];
        for(int i = n ; i >= 1 ; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[k - 1] = num;
                    if(--k == 0) return res;
                }
            }
        }

        return res;
    }
}