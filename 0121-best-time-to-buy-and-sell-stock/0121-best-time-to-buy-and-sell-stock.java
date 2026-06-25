class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        int maxProfit = 0;
        for(int price : prices){
            if(price < min){
                min = price; // 2 , 1
                max = 0;
            } else if(price > max){
                max = price; // 4
            }

            maxProfit = Math.max(maxProfit , max - min); // 2
        }

        return maxProfit;
    }
}