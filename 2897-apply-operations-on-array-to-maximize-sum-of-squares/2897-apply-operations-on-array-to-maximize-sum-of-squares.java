class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_000 + 7;

        int[] bitwise = new int[32];
        for(int num : nums){
            for(int i = 0 ; i < 32 ; i++){
                if((num & (1 << i)) != 0) bitwise[i]++;
            }
        }

        //for(int bit : bitwise) System.out.print(bit + " ");

        long sum = 0;
        for(int i = 0 ; i < k ; i++){
            long curr = 0;
            for(int j = 0 ; j < 32 ; j++){
                if(bitwise[j] > 0){
                    curr |= (1 << j);
                    bitwise[j]--;
                }
            }
            sum = (sum + (curr * curr) % MOD) % MOD;
        }

        return (int) sum;
    }
}