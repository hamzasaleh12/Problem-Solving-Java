class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int max = 0;
        int res = 0;
        for(int num : map.keySet()){
            int curr = map.get(num);
            if(curr > max){
                max = curr;
                res = num;
            }
        }

        return res;
    }
}