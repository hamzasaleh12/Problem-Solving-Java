class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sortedNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = nums[i];
        }

        Arrays.sort(sortedNums, (a, b) -> {
            int fir = sum(a), sec = sum(b);
            if (fir == sec) {
                return Integer.compare(a, b);
            }
            return Integer.compare(fir, sec);
        });

        Map<Integer, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndex.put(sortedNums[i], i);
        }

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || targetIndex.get(nums[i]) == i) {
                continue;
            }

            int cycleLength = 0;
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                curr = targetIndex.get(nums[curr]);
                cycleLength++;
            }

            totalSwaps += (cycleLength - 1);
        }

        return totalSwaps;
    }

    private int sum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }
}