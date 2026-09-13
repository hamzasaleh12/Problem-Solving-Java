import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) l1.add(new int[]{i, j});
                if (img2[i][j] == 1) l2.add(new int[]{i, j});
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : l1) {
            for (int[] p2 : l2) {
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                
                String vector = dx + "," + dy; 
                
                int count = map.getOrDefault(vector, 0) + 1;
                map.put(vector, count);
                
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
    }
}