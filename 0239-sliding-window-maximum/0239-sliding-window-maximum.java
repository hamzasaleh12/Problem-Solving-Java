class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0] , a[0]));

        int left = 0;
        for(int i = 0 ; i < nums.length ; i++){
            pq.add(new int[]{nums[i] , i});
            if(i >= k - 1){ // 0 , 1 , 2
                while(!pq.isEmpty() && i - pq.peek()[1] >= k){
                    pq.poll();
                }
                res[left++] = pq.peek()[0];
            }
        }

        return res;   
    }
}