class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[speed.length][2];
        for(int i = 0 ; i < speed.length ; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // time
        }
        // [[10,1] , [8 , 1] , [0 , 12] , [5 , 6] , [3 , 3]]

        Arrays.sort(cars , (a , b) -> Double.compare(b[0] , a[0]));

        // [[10 , 1] , [8 , 1] , [5 , 6] , [3 , 3] , [0 , 12]]

        int fleets = 0;
        double maxTime = 0;
        for(int i = 0 ; i < speed.length ; i++){
            if(maxTime < cars[i][1]){ //  t , f , t , f , t
                maxTime = cars[i][1]; // 1 , 6 , 12
                fleets++; // 1 , 2 , 3
            }
        }
        return fleets;
    }
}