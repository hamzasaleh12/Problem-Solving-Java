class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals , (a,b) -> Integer.compare(a[1] , b[1]));

        int[] current = intervals[0];
        int count = -1;
        for(int[] interval : intervals){
            int currEnd = current[1];
            int nextStart = interval[0];

            if(currEnd > nextStart){
                count++;
            } else{
                current = interval;
            }
        }

        return count;
    }
}