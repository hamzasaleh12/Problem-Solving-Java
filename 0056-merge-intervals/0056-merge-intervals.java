class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals , (a , b) -> Integer.compare(a[0] , b[0]));

        int[] current = intervals[0]; // [1,3]
        res.add(current);
        for(int[] interval : intervals){
            int currEnd = current[1]; // 3
            int nextStart = interval[0]; // 2
            int nextEnd = interval[1]; // 2

            if(currEnd >= nextStart){
                current[1] = Math.max(nextEnd , currEnd);
            } else{
                current = interval;
                res.add(current);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}