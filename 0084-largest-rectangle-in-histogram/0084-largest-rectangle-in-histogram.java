class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxRecArea = 0;

        int[] newHeights = new int[heights.length + 1];
        for(int i = 0; i < heights.length ; i++){
            newHeights[i] = heights[i];
        }
        newHeights[heights.length] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < newHeights.length ; i++){
            while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]){
                int height = newHeights[stack.pop()];
                int width = (!stack.isEmpty()) ? i - stack.peek() - 1 : i;
                maxRecArea = Math.max(maxRecArea , height * width);
            }
            stack.push(i); // 0
        }

        return maxRecArea;
    }
}