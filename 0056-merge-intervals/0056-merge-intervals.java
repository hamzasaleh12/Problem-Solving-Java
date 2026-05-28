class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals , (a , b) -> Integer.compare(a[0] , b[0]));

        int[] current = intervals[0]; // [1,3]
        for(int[] interval : intervals){
            int currBegain = current[0]; // 1
            int currEnd = current[1]; // 3
            int nextBegain = interval[0]; // 2

            if(currEnd >= nextBegain){
                interval[0] = currBegain;
                interval[1] = Math.max(interval[1] , currEnd);
            } else{
                res.add(current);
            }
            current = interval;
        }
        res.add(current);

        return res.toArray(new int[res.size()][]);
    }
}