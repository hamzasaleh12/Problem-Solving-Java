class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int giv1 = target[0] , giv2 = target[1] , giv3 = target[2]; // targets (given)
        boolean found1 = false , found2 = false , found3 = false;

        for(int i = 0 ; i < triplets.length ; i++){
            int num1 = triplets[i][0] , num2 = triplets[i][1] , num3 = triplets[i][2];
            if(num1 > giv1 || num2 > giv2 || num3 > giv3) continue; // invalid triplet

            // merging
            if(num1 == giv1) found1 = true;
            if(num2 == giv2) found2 = true;
            if(num3 == giv3) found3 = true;
            
            if(found1 && found2 && found3) return true;
        }

        // check equality
        return false;
    }
}