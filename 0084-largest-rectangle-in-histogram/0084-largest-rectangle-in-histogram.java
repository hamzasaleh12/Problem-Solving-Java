class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int n = heights.length;
        int maxArea = 0;
        
        int[] stack = new int[n + 1]; 
        int top = -1;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (top != -1 && currentHeight < heights[stack[top]]) {
                int h = heights[stack[top--]]; 
                int w = (top == -1) ? i : i - stack[top] - 1;
                
                maxArea = Math.max(maxArea, h * w);
            }
            
            stack[++top] = i;
        }

        return maxArea;
    }
}