class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i , j , dis});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        
        // DSU
        int[] parent = new int[n];
        for(int i = 1 ; i < n ; i++) parent[i] = i;

        int[] rank = new int[n];

        int sum = 0;
        int edgesCount = 0;
        for(int[] edge : edges){
            if(edgesCount == n - 1) break;

            int u = find(edge[0] , parent);
            int v = find(edge[1] , parent);

            if(u == v) continue; // Cycle

            union(u , v , parent , rank);
            sum += edge[2];
            edgesCount++;
        }

        return sum;
    }
    private int find(int val , int[] parent){
        if(val == parent[val]) return val;
        return parent[val] = find(parent[val] , parent);
    }
    private void union(int fir , int sec , int[] parent , int[] rank){
        if(rank[fir] > rank[sec]){
            parent[sec] = fir;
        } else if(rank[sec] > rank[fir]){
            parent[fir] = sec;
        } else{
            parent[sec] = fir;
            rank[fir]++;
        }
    }
}