class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1 ; i < 13 ; i++){
            month[i] += month[i - 1];
        }

        int aliceArr = month[Integer.parseInt(arriveAlice.substring(0 , 2)) - 1] + Integer.parseInt(arriveAlice.substring(3));
        int aliceLea = month[Integer.parseInt(leaveAlice.substring(0 , 2)) - 1] + Integer.parseInt(leaveAlice.substring(3));
        int BobArr = month[Integer.parseInt(arriveBob.substring(0 , 2)) - 1] + Integer.parseInt(arriveBob.substring(3));
        int BobLea = month[Integer.parseInt(leaveBob.substring(0 , 2)) - 1] + Integer.parseInt(leaveBob.substring(3));

        return Math.max(0 , Math.min(aliceLea , BobLea) - Math.max(aliceArr , BobArr) + 1);
    }
}