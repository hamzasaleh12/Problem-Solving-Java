class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int n1 = num1.length() , n2 = num2.length();
        int[] res = new int[n1 + n2];

        for(int j = n2 - 1 ; j >= 0 ; j--){
            for(int i = n1 - 1 ; i >= 0 ; i--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int sum = res[i + j + 1] + mul;
                res[i + j + 1] = sum % 10; // curr
                res[i + j] += sum / 10; // next (carry)
            }
        }


        int i = 0;
        while(i < res.length && res[i] == 0){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(int k = i ; k < res.length ; k++){
            sb.append(res[k]);
        }

        return sb.toString();
    }
}