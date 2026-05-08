class Solution {
    record Data(int curr , int path , int k){};
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] flight : flights){
            map.computeIfAbsent(flight[0] , key -> new ArrayList<>()).add(new int[] {flight[1] , flight[2]}); // 0 : 1,100
        }

        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.path , b.path));
        pq.add(new Data(src,0,k));

        int[] minStops = new int[n];
        Arrays.fill(minStops, -1);

        while(!pq.isEmpty()){
            Data data = pq.poll();
            int u = data.curr , price = data.path , stops = data.k;

            if(u == dst) return data.path;
            if(stops < 0 || stops <= minStops[u]) continue;

            minStops[u] = stops;
            
            for(int[] neighbor : map.getOrDefault(data.curr , new ArrayList<>())){
                pq.add(new Data(neighbor[0], price + neighbor[1] , stops - 1));
            }
        }
        return -1;
    }
}