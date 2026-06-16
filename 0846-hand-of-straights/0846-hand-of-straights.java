class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);

        Map<Integer,Integer> map = new HashMap<>();
        for(int h : hand){
            map.put(h , map.getOrDefault(h,0) + 1);
        }

        for(int i = 0 ; i < hand.length ; i++){
            if(map.get(hand[i]) == 0) continue;
            
            int start = hand[i];
            for(int j = 0 ; j < groupSize ; j++){
                int curr = start + j;

                if(!map.containsKey(curr) || map.get(curr) == 0) return false;

                map.put(curr , map.get(curr) - 1);
            }
        }
        return true;
    }
}