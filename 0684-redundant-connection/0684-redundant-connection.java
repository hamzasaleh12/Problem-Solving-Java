class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for(int i = 1 ; i <= edges.length ; i++){
            parents[i] = i; // 1 -> 1 , ...
        }

        for(int[] edge : edges){
            int firPar = find(edge[0] , parents);
            int secPar = find(edge[1] , parents);

            if(firPar != secPar) union(firPar , secPar , parents , rank);

            else return new int[]{edge[0] , edge[1]};
        }
        
        return null;
    }
    // [0 , 1 , 1 , 2 , 2 , 3] -> 5
    private int find(int val , int[] parents){ // 5 , parents  , 3
        if(parents[val] == val) return val; // 3 = 5 ? f , 2 = 3 ? f , 1 = 2 ? f , 1 = 1 ? t

        return parents[val] = find(parents[val] , parents); // كاني بعمل كاشينج للمعلومه
    }
    private void union(int fir , int sec , int[] parents , int[] rank){
        if(rank[fir] >= rank[sec]) parents[sec] = fir;
        else parents[fir] = sec;
    }
}