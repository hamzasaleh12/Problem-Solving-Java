class Solution {
    public boolean sumGame(String num) {
        int qLeft = 0, qRight = 0;
        int sumLeft = 0, sumRight = 0;
        int mid = num.length() / 2;
        
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '?') {
                if (i >= mid) qRight++;
                else qLeft++;
            } else {
                int val = c - '0';
                if (i >= mid) sumRight += val;
                else sumLeft += val;
            }
        }
        
        if (((qLeft + qRight) & 1) != 0) return true; 
        
        return (sumLeft - sumRight) + (qLeft - qRight) / 2 * 9 != 0;
    }
}