class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visisted = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));
        pq.add(new int[]{0,0});

        int sum = 0;
        int totalEdges = 0; 
        while(!pq.isEmpty() && totalEdges < n){
            int[] curr = pq.poll();
            int x = curr[0] , val = curr[1];

            if(visisted[x]) continue; // cycle

            visisted[x] = true;
            for(int i = 0; i < n ; i++){
                if(visisted[i]) continue;
                pq.add(new int[]{i , Math.abs(points[x][0] - points[i][0]) + Math.abs(points[x][1] - points[i][1])});
            }
            totalEdges++;
            sum += val;
        }
        return sum;
    }
}