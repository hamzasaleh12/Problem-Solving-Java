class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        int[] res = new int[qLen];

        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] serverFreq = new int[n + 1];
        int activeServers = 0;

        int left = 0;
        int right = 0;

        for (int[] q : sortedQueries) {
            int queryTime = q[0];
            int originalIndex = q[1];

            int windowStart = queryTime - x;
            int windowEnd = queryTime;

            while (right < logs.length && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                if (serverFreq[serverId] == 0) {
                    activeServers++;
                }
                serverFreq[serverId]++;
                right++;
            }

            while (left < logs.length && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverFreq[serverId]--;
                if (serverFreq[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            res[originalIndex] = n - activeServers;
        }

        return res;
    }
}