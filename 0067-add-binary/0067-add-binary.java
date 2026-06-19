class Solution {
    public String addBinary(String a, String b) {
        int nb = b.length() - 1 , na = a.length() - 1;
        // "abcd"

        StringBuilder sb = new StringBuilder();
        int c = 0;

        int i = na, j = nb;
        while(i >= 0 || j >= 0 || c != 0){
            int numa = (i < 0) ? 0 : a.charAt(i) - '0';
            int numb = (j < 0) ? 0 : b.charAt(j) - '0';
                
            int sum = numa + numb + c; // 0 or 1 or 2 or 3
            if(sum == 2){
                sb.append(0);
                c = 1;
            } else if(sum == 3){
                sb.append(1);
                c = 1;
            } else{ // sum = 0 or 1
                sb.append(sum);
                c = 0;
            }
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}