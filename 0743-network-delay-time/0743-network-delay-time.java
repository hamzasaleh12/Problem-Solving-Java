class Solution {
    class Data{
        int node;
        int dis;
        public Data(int node , int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            if(i == k) continue;
            distance[i] = Integer.MAX_VALUE;
        }
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] time : times){
            map.computeIfAbsent(time[0] , key -> new ArrayList<>()).add(new int[]{time[1] , time[2]});
        }

        PriorityQueue<Data> queue = new PriorityQueue<>((a , b) -> Integer.compare(a.dis , b.dis));
        queue.add(new Data(k , distance[k])); // (2,0)

        while(!queue.isEmpty()){
            Data t = queue.poll(); // (node:2,dis:0) , 1 , 3
            if(distance[t.node] < t.dis) continue;

            for(int[] neighbor : map.getOrDefault(t.node , new ArrayList<>())){
                // Relaxation
                int targetNode = neighbor[0]; // 1 , 3 , 4
                int disEdge = neighbor[1];//2 -'1'-> 1 , 2 -'1'-> 3 , 1

                if(t.dis + disEdge < distance[targetNode]){ // 0 + 1 < INF , 0 + 1 < INF
                    distance[targetNode] = t.dis + disEdge; // dis[1] = 1 , dis[3] = 1
                    queue.add(new Data(targetNode , distance[targetNode])); // 1 , 3
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int dis : distance){
            if(dis == Integer.MAX_VALUE) return -1;
            max = Math.max(max , dis);
        }

        return max;
    }
}