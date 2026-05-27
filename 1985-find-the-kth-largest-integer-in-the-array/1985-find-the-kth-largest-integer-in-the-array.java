class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(k + 1 , (a,b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return Integer.compare(a.length() , b.length());
        });

        for(String num : nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}