class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        
        int prev = 10;
        boolean alice = false;
        while(n - prev >= 0){
            n -= prev;
            prev--;
            alice = !alice;
        }

        return alice;
    }
}