class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> 
            Integer.compare(
                (y[0] * y[0] + y[1] * y[1]), 
                (x[0] * x[0] + x[1] * x[1])
            )
        );

        for(int[] p : points){
            queue.add(p);

            if(queue.size() > k){
                queue.poll();
            }
        }

        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = queue.poll();
        }

        return res;
    }
}