class Solution {
    private final static int[][] drs = {{0,1} , {1,0} , {0,-1} , {-1,0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2] , b[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        boolean[][] visisted = new boolean[n][n];

        int max = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0] , y = curr[1];

            if(visisted[x][y]) continue;
            visisted[x][y] = true;

            max = Math.max(max , curr[2]); // 1

            if(x == n - 1 && y == n - 1) return max;

            for(int[] d : drs){
                int r = x + d[0];
                int c = y + d[1];

                if(r >= 0 && r < n && c >= 0 && c < n && !visisted[r][c]){
                    pq.add(new int[]{r , c , grid[r][c]}); // 1 , 24
                }
            }
        }
        return max;
    }
}