class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int pile : piles){
            high = Math.max(high , pile);
        }

        int low = 1;
        while(low < high){
            int mid = low + high >>> 1;

            long count = 0;
            for(int pile : piles){
                count += (pile + mid - 1) / mid;
            }

            if(count <= h) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}