class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int ri = 0;
        
        for(int i = 0 ; i < nums.length ; i++){

           if(!deque.isEmpty() && deque.peekFirst() == i - k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
