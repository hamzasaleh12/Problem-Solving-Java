class Solution {
    record Data(int node, int dis) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        
        for (int[] time : times) {
            adj[time[0]].add(new int[]{time[1], time[2]});
        }

        PriorityQueue<Data> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.dis, b.dis));
        queue.add(new Data(k, 0));

        while (!queue.isEmpty()) {
            Data t = queue.poll();
            if (distance[t.node] < t.dis) continue;

            for (int[] neighbor : adj[t.node]) {
                int targetNode = neighbor[0];
                int disEdge = neighbor[1];

                if (t.dis + disEdge < distance[targetNode]) {
                    distance[targetNode] = t.dis + disEdge;
                    queue.add(new Data(targetNode, distance[targetNode]));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }

        return max;
    }
}