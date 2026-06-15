class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1] , a[1]));
        int n = gas.length;
        if(n == 1 && gas[0] == cost[0]) return 0;

        for(int i = 0 ; i < n ; i++){
            if(gas[i] <= cost[i]) continue;
            int[] curr = new int[]{i , gas[i] - cost[i]};
            pq.add(curr);
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int idx = curr[0]; // 3 -> {4}
            int count = 0;

            int currIdx = idx; // 3
            int currSum = gas[currIdx]; // 4
            while(currSum >= cost[currIdx]){
                if(count == n) return idx;

                count++; // t,t,t,t
                int nextIdx = (currIdx != n - 1) ? currIdx + 1 : 0; // 4,0,1,2

                currSum = currSum - cost[currIdx] + gas[nextIdx]; // 8,7,6,5
                currIdx = nextIdx; // 4,0,1,2
            }
        }
        return -1;
    }
}