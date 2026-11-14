class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] p = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums.get(i);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = l; j <= n; j++) {
            map.put(p[j - l], j - l);

            var entry = map.lowerEntry(p[j]);
            while (entry != null) {
                if (entry.getValue() < j - r) {
                    map.remove(entry.getKey());
                    entry = map.lowerEntry(p[j]);
                } else {
                    minSum = Math.min(minSum, p[j] - entry.getKey());
                    break;
                }
            }
        }

        return (minSum == Integer.MAX_VALUE) ? -1 : minSum;
    }
}