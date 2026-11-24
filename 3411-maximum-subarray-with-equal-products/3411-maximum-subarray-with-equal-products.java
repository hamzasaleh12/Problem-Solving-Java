class Solution {
    public int maxLength(int[] nums) {
        int prod = 1 , best = 2 , left = 0;
        for(int right = 0 ; right < nums.length ; right++){
            while(gcd(prod , nums[right]) > 1){
                prod /= nums[left++];
            }
            prod *= nums[right];
            best = Math.max(best , right - left + 1);
        }
        return best;
    }
    private int gcd(int a , int b){ 
        return (b == 0) ? a : gcd(b , a % b);
    }
}