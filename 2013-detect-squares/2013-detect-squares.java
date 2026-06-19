class DetectSquares {
    private int[][] count;
    private List<int[]> points;

    public DetectSquares() {
        count = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        count[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int ans = 0;
        for(int[] p : points){
            ans += getSquaresFromDiagonal(p, point);
        }
        return ans;
    }

    private int getSquaresFromDiagonal(int[] p , int[] q){
        int px = p[0] , py = p[1];
        int qx = q[0] , qy = q[1];

        if(px == qx || Math.abs(px - qx) != Math.abs(py - qy)){
            return 0;
        }

        return count[px][qy] * count[qx][py];
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */