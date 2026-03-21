class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        int count = 0;
        while(left < right){
            if(height[left] <= height[right]){
                left++;
                if(maxLeft < height[left]){
                    maxLeft = Math.max(maxLeft , height[left]);
                }
                count += maxLeft - height[left];
            } else{
                right--;
                if(maxRight < height[right]){
                    maxRight = Math.max(maxRight , height[right]);
                }
                count += maxRight - height[right];
            }
        }
        return count;
    }
}