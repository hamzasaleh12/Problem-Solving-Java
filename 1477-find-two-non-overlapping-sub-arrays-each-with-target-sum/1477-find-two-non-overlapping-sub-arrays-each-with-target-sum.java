class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 100_005;

        int[] minLen = new int[n];
        Arrays.fill(minLen , INF);


        long sum = 0;
        int left = 0;
        int ans = INF;
        for(int right = 0 ; right < n ; right++){
            sum += arr[right]; // 5
            while(sum > target){ // j = 2
                sum -= arr[left++]; // 3
            }

            if(sum == target){
                int currLen = right - left + 1;
                if(left > 0 && minLen[left - 1] != INF){
                    ans = Math.min(ans , currLen + minLen[left - 1]);
                }

                minLen[right] = currLen;
            }

            if(right > 0){
                minLen[right] = Math.min(minLen[right] , minLen[right - 1]);
            }
        }

        return (ans == INF) ? -1 : ans;
    }
}