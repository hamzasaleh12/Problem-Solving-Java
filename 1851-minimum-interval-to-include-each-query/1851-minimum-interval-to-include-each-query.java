class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] newQueries = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            newQueries[i][0] = queries[i];
            newQueries[i][1] = i;
        }
        Arrays.sort(newQueries , (a,b) -> Integer.compare(a[0] , b[0]));

        int m = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare((a[1] - a[0] + 1), (b[1] - b[0] + 1))
        );

        int[] res = new int[n];
        int intervalIdx = 0;
        for(int i = 0 ; i < n ; i++){
            int queryVal = newQueries[i][0];
            int originalIdx = newQueries[i][1];

            while(intervalIdx < m && intervals[intervalIdx][0] <= queryVal){
                pq.add(intervals[intervalIdx]);
                intervalIdx++;
            }
            
            while(!pq.isEmpty() && pq.peek()[1] < queryVal){
                pq.poll();
            }


            if(pq.isEmpty()){
                res[originalIdx] = -1;
            } else{
                int[] best = pq.peek();
                res[originalIdx] = best[1] - best[0] + 1;
            }
        }

        return res;
    }
}