class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        for(int i = 0 ; i < nums.length ; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.getLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && i - deque.getFirst() >= k){
                deque.pollFirst();
            }

            deque.addLast(i); // 3 1 1
            if(i - left + 1 >= k){
                res[left++] = nums[deque.getFirst()];
            }
        }

        return res;   
    }
}