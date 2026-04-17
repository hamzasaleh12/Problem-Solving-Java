class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            queue.add(stone);
        }
        while(queue.size() > 1){
            int fir = queue.poll();
            int sec = queue.poll();

            if(fir > sec) queue.add(fir - sec);
            else if(sec > fir) queue.add(sec - fir);
        }
        return (queue.isEmpty()) ? 0 : queue.peek();
    }
}