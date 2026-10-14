class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9) return "";

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num ; i++){
            if(sum < 9){
                if(sum != 0){sb.append(sum % 10 + ""); sum = 0;}
                else sb.append('0');
            } else{
                sb.append('9');
                sum -= 9;
            }
        }

        return sb.toString();
    }
}