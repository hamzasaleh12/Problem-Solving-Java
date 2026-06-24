class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int n = nums.length / 3;
        for(int num : map.keySet()){
            if(map.get(num) > n){
                res.add(num);
            }
        }
        
        return res;
    }
}