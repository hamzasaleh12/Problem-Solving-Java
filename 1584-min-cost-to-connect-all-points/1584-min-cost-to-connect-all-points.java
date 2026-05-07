class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0) return 0;

        int l = points.length; int w = points[0].length;
        boolean[] visited = new boolean[l];

        int[] minDis = new int[l];
        Arrays.fill(minDis , Integer.MAX_VALUE);
        minDis[0] = 0;

        int tarSum = 0;
        for(int i = 0 ; i < l ; i++){
            int min = Integer.MAX_VALUE; int idx = Integer.MAX_VALUE;
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
                if(!visited[j]) minDis[j] = Math.min(minDis[j] , dis(idx , j , points));
            }
        }
        return tarSum;
    }
    private int dis(int i , int j , int[][] points){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}