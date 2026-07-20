class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for(int i = 0 ; i <= n ; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] time : times){
            adj[time[0]].add(new int[]{time[1] , time[2]});
        }

        // [ [2 -> [1,1] , [3,1]] , [3 -> [4,1]] ]
        int[] minDis = new int[n + 1];
        Arrays.fill(minDis , Integer.MAX_VALUE);
        minDis[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));
        pq.add(new int[]{k , 0});
        minDis[k] = 0;
        
        boolean[] visisted = new boolean[n + 1];
        visisted[0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll(); // [2,0]

            int u = curr[0] , dis = curr[1];
            if(visisted[u]) continue;

            visisted[u] = true;
            for(int[] num : adj[u]){
                int nextNode = num[0];
                int edgeWeight = num[1];
                int newDist = dis + edgeWeight;

                if(newDist < minDis[nextNode]){
                    minDis[nextNode] = newDist;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        int max = 0;
        for(int d : minDis){
            if(d == Integer.MAX_VALUE) return -1;
            max = Math.max(max , d);
        }
        return max;
    }
}