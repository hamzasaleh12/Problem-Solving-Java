class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();

        int sum = 0;
        boolean[][] count = new boolean[n][101];
        for(int i = 0 ; i < n ; i++){
            int distinctCount = 0;
            for(int j = i ; j < n ; j++){
                int num = nums.get(j); // 1 , 2 , 1
                if(!count[i][num]){ // [0][1] , [0][2] , [0][1]
                    distinctCount++; // 1 , 2
                    count[i][num] = true; // [0][1] , [0][2]
                }
                sum += distinctCount * distinctCount;
            }
        }

        return sum;
    }
}