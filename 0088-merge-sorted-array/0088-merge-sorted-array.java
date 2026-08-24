class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length == 0) return;
        
        List<Integer> list = Arrays.stream(nums2).boxed().toList(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);

        for(int i = 0 ; i < m ; i++){
            if(nums1[i] > pq.peek()){ // 3 <= 2 ?
                int t = nums1[i]; // 3
                nums1[i] = pq.poll(); // [1,2,2,0,0,0]
                pq.add(t); // 3,5,6
            }
        }

        for(int i = m ; i < nums1.length ; i++){
            nums1[i] = pq.poll();
        }
    }
}