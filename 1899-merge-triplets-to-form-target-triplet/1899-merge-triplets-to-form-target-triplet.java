class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        if(triplets.length == 1) return Arrays.equals(triplets[0] , target);

        int giv1 = target[0] , giv2 = target[1] , giv3 = target[2]; // targets (given)
        int tar1 = 0 , tar2 = 0 , tar3 = 0;

        for(int i = 0 ; i < triplets.length ; i++){
            int num1 = triplets[i][0] , num2 = triplets[i][1] , num3 = triplets[i][2];
            if(num1 > giv1 || num2 > giv2 || num3 > giv3) continue; // invalid triplet

            // merging
            tar1 = Math.max(tar1 , num1);
            tar2 = Math.max(tar2 , num2);
            tar3 = Math.max(tar3 , num3);
        }

        // check equality
        return Arrays.equals(new int[]{tar1 , tar2 , tar3} , target);
    }
}