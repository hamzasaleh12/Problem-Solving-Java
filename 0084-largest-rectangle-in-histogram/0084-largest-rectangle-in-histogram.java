class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = Arrays.copyOf(heights , n + 1);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0 ; i < n + 1 ; i++){
            while(!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]){
                int h = newHeights[stack.pop()]; // 1
                int prev = (stack.isEmpty()) ? -1 : stack.peek(); // 0
                maxArea = Math.max(maxArea , h * (i - prev - 1));
            }

            stack.push(i);
        }

        return maxArea;
    }
}