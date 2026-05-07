class Solution {
    record Data(int row, int col, int height){}

    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int l = grid.length; int w = grid[0].length;

        int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};

        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.height , b.height));
        boolean[][] visited = new boolean[l][w];
        pq.add(new Data(0,0,grid[0][0]));

        while(!pq.isEmpty()){
            Data point = pq.poll();
            if (point.row == l - 1 && point.col == w - 1) return point.height;

            if(visited[point.row][point.col]) continue;
            visited[point.row][point.col] = true;

            for(int[] d : drs){
                int row = point.row + d[0];
                int col = point.col + d[1];
                if(row >= 0 && row < l && col >= 0 && col < w && !visited[row][col]){
                    pq.add(new Data(row , col , Math.max(point.height , grid[row][col])));
                }
            }
        }
        return 0;
    }
}