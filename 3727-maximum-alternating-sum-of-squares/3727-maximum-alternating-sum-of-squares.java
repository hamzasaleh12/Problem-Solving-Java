class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        //for(int num : nums) System.out.println(num);
        
        int left = 0 , right = n - 1;
        long sum = 0;
        while(left < right){
            sum += (nums[right] * nums[right]) - (nums[left] * nums[left]); // 8
            left++;
            right--;
        }

        if(left == right) sum += nums[right] * nums[right];

        return sum;
    }
}