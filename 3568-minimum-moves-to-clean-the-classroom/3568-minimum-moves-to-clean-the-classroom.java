class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        char[][] grid = new char[m][n];
        int startr = 0 , startc = 0;
        int Lcount = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                char curr = classroom[i].charAt(j);
                if(curr == 'S'){
                    startr = i;
                    startc = j;
                    grid[i][j] = '.';
                } else if(curr == 'L'){
                    grid[i][j] = (char) ('0' + Lcount++);
                } else{
                    grid[i][j] = curr;
                }
            }
        }
        if (Lcount == 0) return 0;

        int target = (1 << Lcount) - 1;
        boolean[][][][] visited = new boolean[m][n][1 << Lcount][energy + 1];
        int[][] drs = {{0,1} , {1,0} , {-1,0} , {0,-1}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startr , startc , 0 , energy});
        visited[startr][startc][0][energy] = true;

        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                int[] curr = queue.poll();
                int r = curr[0] , c = curr[1] , mask = curr[2] , e = curr[3];

                if(mask == target) return steps;
                if(e == 0) continue;

                for(int[] d : drs){
                    int nr = r + d[0] , nc = c + d[1];
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                    char currChar = grid[nr][nc];
                    if(currChar == 'X') continue;

                    int ne = e - 1;
                    int nextMask = mask;

                    if(currChar >= '0' && currChar <= '9'){
                        nextMask |= (1 << (currChar - '0'));
                    } else if(currChar == 'R'){
                        ne = energy;
                    }

                    if(!visited[nr][nc][nextMask][ne]){
                        visited[nr][nc][nextMask][ne] = true;
                        queue.add(new int[]{nr,nc,nextMask,ne});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}