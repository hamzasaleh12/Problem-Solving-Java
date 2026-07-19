class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        int minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            int levelSize = queue.size();
            minutes++;

            for (int i = 0; i < levelSize; i++) {
                int[] curr = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];

                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        freshOranges--;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}