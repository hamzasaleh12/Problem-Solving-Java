class Solution {
    public int smallestIndex(int[] nums) {
        // O(n * log(10)) -> O(n)
        for(int i = 0 ; i < nums.length ; i++){
            if(sumDigits(nums[i]) == i) return i; // Return the smallest index
        }
        return -1; // no such index exists, return -1
    }
    private int sumDigits(int num){
        int res = 0;
        while(num != 0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}