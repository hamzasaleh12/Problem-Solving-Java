class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles){
            if(pile > max) max = pile;
        }

        int low = 1;
        int high = max;

        int res = 0;
        while(low <= high){
            int mid = (low + high) >>> 1;

            long hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double) pile / mid);
            }

            if(hours <= h){
                res = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return res;
    }
}