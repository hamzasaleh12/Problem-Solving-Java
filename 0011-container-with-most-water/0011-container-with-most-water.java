class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;
        while(left < right){
            if(height[right] > height[left]){
                maxArea = Math.max(maxArea , (right - left) * height[left]);
                left++;
                while(left < right && height[left] < height[left - 1]) left++;
            } else{
                maxArea = Math.max(maxArea , (right - left) * height[right]);
                right--;
                while(left < right && height[right] < height[right + 1]) right--;
            }
        }
        return maxArea;
    }
}