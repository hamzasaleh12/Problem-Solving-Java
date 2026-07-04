class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b , a));
        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size() > 1){
            int firNum = pq.poll();
            int secNum = pq.poll();
            if(firNum != secNum) pq.add(Math.abs(firNum - secNum));
        }

        return (pq == null || pq.size() == 0) ? 0 : pq.peek();
    }
}