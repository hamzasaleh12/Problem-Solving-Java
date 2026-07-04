class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[2] , a[2]));
        int n = points.length;

        int[][] pointsWithDis = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            int x = points[i][0]; pointsWithDis[i][0] = x;
            int y = points[i][1]; pointsWithDis[i][1] = y;
            pointsWithDis[i][2] = x * x + y * y;

            pq.add(pointsWithDis[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            int[] curr = pq.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
        }

        return res;
    }
}