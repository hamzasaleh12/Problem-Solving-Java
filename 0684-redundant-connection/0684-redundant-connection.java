class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            parent[i] = i;
        }
        // [0,1,2,2]

        for(int[] edge : edges){
            int u = find(edge[0] , parent); // 1
            int v = find(edge[1] , parent); // 2

            if(u == v) return edge;
            union(u , v , parent);
        }
        return null;
    }
    private int find(int val , int[] parent){ // 1
        if(val == parent[val]) return val; // 1
        return parent[val] = find(parent[val] , parent);
    }
    private void union(int fir , int sec , int[] parent){
        parent[sec] = fir;
    }
}