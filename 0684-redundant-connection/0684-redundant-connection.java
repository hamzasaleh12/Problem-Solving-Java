class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for(int i = 1 ; i <= edges.length ; i++){
            parents[i] = i;
        }

        for(int[] edge : edges){
            int firPar = find(edge[0] , parents);
            int secPar = find(edge[1] , parents);

            if(firPar != secPar) union(firPar , secPar , parents , rank);

            else return new int[]{edge[0] , edge[1]};
        }
        
        return null;
    }
    
    private int find(int val , int[] parents){
        if(parents[val] == val) return val;

        return parents[val] = find(parents[val] , parents);
    }
    private void union(int fir , int sec , int[] parents , int[] rank){
        if(rank[fir] > rank[sec]) {
            parents[sec] = fir;
        }
        else if(rank[sec] > rank[fir]) {
            parents[fir] = sec;
        } else{
            parents[sec] = fir;
            rank[fir]++;
        }
    }
}