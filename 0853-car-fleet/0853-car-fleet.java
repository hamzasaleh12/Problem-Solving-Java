class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] fleets = new double[n][2];
        for(int i = 0 ; i < n ; i++){
            fleets[i][0] =  position[i];
            fleets[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(fleets , (a,b) -> Double.compare(b[0] , a[0]));
        
        int count = 1;
        double maxTime = fleets[0][1];
        for(int i = 1 ; i < n ; i++){
            if(fleets[i][1] > maxTime){
                count++;
                maxTime =  fleets[i][1];
            }
        }

        return count;
    }
}