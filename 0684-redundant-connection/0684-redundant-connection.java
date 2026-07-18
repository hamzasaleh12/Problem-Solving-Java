class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parents = new int[n + 1];
        int[] rank = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            parents[i] = i;
        }

        for(int[] edge : edges){
            int firPar = find(edge[0] , parents);
            int secPar = find(edge[1] , parents);

            if(firPar == secPar) return edge;
            union(firPar , secPar , parents , rank);
        }
        
        return null;
    }
    
    private int find(int val , int[] parents){
        if(parents[val] == val) return val;
        return parents[val] = find(parents[val] , parents);
    }
    private void union(int fir , int sec , int[] parents , int[] rank){
        if(rank[fir] > rank[sec]){
            parents[sec] = fir;
        } else if(rank[sec] > rank[fir]){
            parents[fir] = sec;
        } else{
            parents[sec] = fir;
            rank[fir]++;
        }
    }
}