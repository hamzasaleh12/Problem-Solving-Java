class Solution {
    public int trap(int[] height) {
        int left = 0 , maxLeft = height[left];
        int right = height.length - 1 , maxRight = height[right];

        int res = 0;
        while(left < right){
            if(maxLeft <= maxRight){
                left++;
                maxLeft = Math.max(maxLeft , height[left]);
                res += maxLeft - height[left]; 
            } else{
                right--;
                maxRight = Math.max(maxRight , height[right]);
                res += maxRight - height[right];
            }
        }

        return res;
    }
}