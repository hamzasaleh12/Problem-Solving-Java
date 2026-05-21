class Solution {
    public int[][] merge(int[][] intervals) {
       if (intervals.length <= 1) return intervals;

       Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

       int[] cuurentInterval = intervals[0];
       List<int[]> result = new ArrayList<>();
       result.add(cuurentInterval);

        for(int[] interval : intervals){
            int currentEnd = cuurentInterval[1];
            int nextBegain = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextBegain){
                cuurentInterval[1] = Math.max(currentEnd,nextEnd);
            }else{
                cuurentInterval = interval;
                result.add(cuurentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}