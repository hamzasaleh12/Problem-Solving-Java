class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String , PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.computeIfAbsent(ticket.get(0) , k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        dfs("JFK" , map , res);

        List<String> result = new ArrayList<>();
        for(int i = res.size() - 1 ; i >= 0 ; i--){
            result.add(res.get(i));
        }
        return result;
    }
    private void dfs(String city , Map<String , PriorityQueue<String>> map , List<String> res){
        PriorityQueue<String> pq = map.get(city);

        while(pq != null && !pq.isEmpty()){
            String nextCity = map.get(city).poll();
            dfs(nextCity , map , res);
        }

        res.add(city);
    }
}