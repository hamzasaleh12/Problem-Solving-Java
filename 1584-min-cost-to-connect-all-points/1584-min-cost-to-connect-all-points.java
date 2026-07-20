class Solution {
    public int minCostConnectPoints(int[][] points) {
        int l = points.length;
        boolean[] visited = new boolean[l];

        int[] minDis = new int[l];
        Arrays.fill(minDis , Integer.MAX_VALUE);
        minDis[0] = 0;

        int tarSum = 0;
        for(int i = 0 ; i < l ; i++){
            int min = Integer.MAX_VALUE , idx = Integer.MAX_VALUE;
            for(int j = 0 ; j < l ; j++){
                if(!visited[j] && minDis[j] < min) {
                    min = minDis[j];
                    idx = j;
                }
            }

            if(min == Integer.MAX_VALUE) break;

            visited[idx] = true;
            tarSum += min;
            for(int j = 0 ; j < l ; j++){
                if(!visited[j]) minDis[j] = Math.min(minDis[j] , Math.abs(points[idx][0] - points[j][0]) +
                Math.abs(points[idx][1] - points[j][1]));
            }
        }
        return tarSum;
    }
}