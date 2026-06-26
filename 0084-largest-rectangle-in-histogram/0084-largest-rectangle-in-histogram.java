class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0 ; i <= n ; i++){
            int currVal = (i != n) ? heights[i] : 0;

            while(!stack.isEmpty() && heights[stack.peek()] > currVal){
                int h = heights[stack.pop()];

                int prev = (stack.isEmpty()) ? -1 : stack.peek();
                
                maxArea = Math.max(maxArea , h * (i - prev - 1));
            }

            stack.push(i);
        }

        return maxArea;
    }
}