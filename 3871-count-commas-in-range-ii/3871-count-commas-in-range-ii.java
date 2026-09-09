class Solution {
    public long countCommas(long n) {
        long commas = 0;
        long base = 1000;
        while(n >= base){
            commas += (n - base + 1);
            base *= 1000;
        }

        return commas;
        
        // if(n < 1000) return 0;
        // if(n < 1000000) return n - 1000 + 1;
        // if(n < 1000000000) return (n - 1000 + 1) + 2 * (n - 1000000 + 1);
        // if(n < 1000000000000) return (n - 1000 + 1) + 2 * (n - 1000000 + 1) + 3 * (n - 1000000000 + 1);
        // if(n < 1000000000000000) return (n - 1000 + 1) + 2 * (n - 1000000 + 1) + 3 * (n - 1000000000 + 1) + 4 * (n - 1000000000000 + 1);
    }
}