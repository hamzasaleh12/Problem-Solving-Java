class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((idxA, idxB) -> {
            int distA = points[idxA][0] * points[idxA][0] + points[idxA][1] * points[idxA][1];
            int distB = points[idxB][0] * points[idxB][0] + points[idxB][1] * points[idxB][1];
            return Integer.compare(distB, distA); // Max-Heap
        });

        for(int i = 0 ; i < n ; i++){
            pq.add(i);
            
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            res[i] = points[pq.poll()];
        }

        return res;
    }
}