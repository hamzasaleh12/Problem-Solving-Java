class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int sumGas = 0;
        int sumCost = 0;
        for(int i = 0; i < n ; i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if(sumCost > sumGas) return -1;

        int total = 0;
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            total += gas[i] - cost[i];

            if(total < 0){
                total = 0;
                idx = i + 1;
            }
        }
        return idx;
    }
}