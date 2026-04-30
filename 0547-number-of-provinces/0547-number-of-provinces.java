class Solution {
    public int findCircleNum(int[][] isConnected) {
        int l = isConnected.length , w = isConnected[0].length;
        int[] par = new int[l];
        int[] rank = new int[l];
        for(int i = 0 ; i < l ; i++){
            par[i] = i;
        }
        int[] count = {l};

        for(int i = 0 ; i < l ; i++){
            for(int j = i + 1 ; j < w ; j++){
                if(isConnected[i][j] == 1){
                    int firRoot = find(i , par);
                    int secRoot = find(j , par);

                    if(firRoot != secRoot) union(firRoot , secRoot , count , par , rank);
                }
            }
        }
        return count[0];
    }

    private int find(int val , int[] par){
        if(par[val] == val) return val;
        return par[val] = find(par[val] , par);
    }
    private void union(int fir , int sec , int[] count , int[] par , int[] rank){
        if(rank[fir] > rank[sec]) par[sec] = fir;
        else if(rank[fir] < rank[sec]) par[fir] = sec;
        else{
            par[sec] = fir;
            rank[fir]++;
        }
        count[0]--;
    }
}