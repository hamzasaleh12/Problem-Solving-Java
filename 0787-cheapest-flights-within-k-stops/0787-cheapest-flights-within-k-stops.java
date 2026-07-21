class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] f : flights){
            map.computeIfAbsent(f[0] , a -> new ArrayList<>()).add(new int[]{f[1] , f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1])); // least price
        pq.add(new int[]{src , 0 , 0});

        int[] minStops = new int[n];
        Arrays.fill(minStops , Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] curr = pq.poll(); // [0,0,0]
            int u = curr[0] , price = curr[1] , stops = curr[2];

            if(u == dst) return price;
            if(stops > minStops[u] || stops > k) continue;
            minStops[u] = stops;

            for(int[] ne : map.getOrDefault(u , new ArrayList<>())){
                pq.add(new int[]{ne[0] , price + ne[1] , stops + 1}); // [1,100,0]
            }
        }

        return -1;
    }
}